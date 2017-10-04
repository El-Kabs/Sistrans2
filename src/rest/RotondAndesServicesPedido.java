package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.RotondAndesTM;
import vos.Pedido;
import vos.Usuario;
import vos.VOConsultaZona;
import vos.VOVerificacionZona;
import vos.Zona;

@Path("Pedido")
public class RotondAndesServicesPedido {
	/**
	 * Clase que expone servicios REST con ruta base: http://"ip o nombre de host":8080/VideoAndes/rest/videos/...
	 * @author Monitores 2017-20


		/**
	 * Atributo que usa la anotacion @Context para tener el ServletContext de la conexion actual.
	 */
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
	 * Metodo que expone servicio REST usando GET que da todos los videos de la base de datos.
	 * <b>URL: </b> http://"ip o nombre de host":8080/VideoAndes/rest/videos
	 * @return Json con todos los videos de la base de datos o json con 
	 * el error que se produjo
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPedidos() {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		List<Pedido> pedido;
		try {
			pedido = tm.darPedido();
		}
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(pedido).build();
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
	public Response getPedidoName( @PathParam("id") Integer id) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		Pedido pedido;
		try {
			pedido = tm.buscarPedidoPorId(id);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(pedido).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPedido(Pedido pedido)
	{
		try {
			RotondAndesTM tm = new RotondAndesTM(getPath());
			tm.addPedido(pedido);
			return Response.status(500).entity(pedido).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity(doErrorMessage(e)).build();
		}

	}


	/**
	 * Metodo que expone servicio REST usando DELETE que elimina el video que recibe en Json
	 * <b>URL: </b> http://"ip o nombre de host":8080/VideoAndes/rest/videos
	 * @param Zona - video a aliminar. 
	 * @return Json con el video que elimino o Json con el error que se produjo
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePedido(Pedido pedido) {
		RotondAndesTM tm = new RotondAndesTM(getPath());
		try {
			tm.deletePedido(pedido);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(pedido).build();
	}

}

