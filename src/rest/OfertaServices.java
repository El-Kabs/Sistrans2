package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.AlohAndesTM;
import vos.VOContrato;
import vos.VOOferta;

@Path("ofertas")
public class OfertaServices {

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
	public Response getOfertas() {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		List<VOOferta> ofertas;
		try {
			ofertas = tm.darOfertas();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ofertas).build();
	}
	
	@GET
	@Path( "/masPedidas" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response get20Ofertas() {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		List<VOOferta> ofertas;
		try {
			ofertas = tm.dar20Ofertas();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(ofertas).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOferta(VOOferta oferta)
	{
		try {
			AlohAndesTM tm = new AlohAndesTM(getPath());
			tm.addOferta(oferta);
			return Response.status(200).entity(oferta).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity(doErrorMessage(e)).build();
		}

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateOferta(VOOferta oferta)
	{
		try {
			AlohAndesTM tm = new AlohAndesTM(getPath());
			tm.updateOferta(oferta);
			return Response.status(200).entity(oferta).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity(oferta).build();
		}

	}

    /**
     * Metodo que expone servicio REST usando DELETE que elimina el video que recibe en Json
     * <b>URL: </b> http://"ip o nombre de host":8080/VideoAndes/rest/videos
     * @param usuario - video a aliminar. 
     * @return Json con el video que elimino o Json con el error que se produjo
     */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteOferta(VOOferta oferta) {
		AlohAndesTM tm = new AlohAndesTM(getPath());
		try {
			tm.deleteOferta(oferta);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(oferta).build();
	}
}
