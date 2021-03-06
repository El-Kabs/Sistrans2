package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;


import tm.AlohAndesTM;
import vos.VOConsulta;
import vos.VOContrato;

@Path("contratos")
public class ContratoServices {
	
	@Context
	private ServletContext context;

	/**
	 * Metodo que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}


	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}

	/**
	 * Metodo que expone servicio REST usando GET que busca el video con el nombre que entra como parametro
	 * <b>URL: </b> http://"ip o nombre de host":8080/VideoAndes/rest/videos/nombre/nombre?nombre=<<nombre>>" para la busqueda"
	 * @param name - Nombre del video a buscar que entra en la URL como parametro 
	 * @return Json con el/los videos encontrados con el nombre que entra como parametro o json con 
	 * el error que se produjo
	 */
	@GET
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getContratos() {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		List<VOContrato> contratos;
		try {
			contratos = tm.darContratos();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(contratos).build();
	}
	
	@GET
	@Path( "/dinero" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getMasContratos() {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		List<VOConsulta> contratos;
		try {
			contratos = tm.darDineroContratos();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(contratos).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addContrato(VOContrato contrato)
	{
		try {
			AlohAndesTM tm = new AlohAndesTM(getPath());
			tm.addContrato(contrato);
			return Response.status(200).entity(contrato).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity(doErrorMessage(e)).build();
		}

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateContrato(VOContrato contrato)
	{
		try {
			AlohAndesTM tm = new AlohAndesTM(getPath());
			tm.updateContrato(contrato);
			return Response.status(200).entity(contrato).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity(contrato).build();
		}

	}

}
