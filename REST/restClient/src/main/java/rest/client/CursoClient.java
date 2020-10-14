package rest.client;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import pojo.Curso;

@Path("/cursos")
public interface CursoClient {

	@GET
	@Path("/listado")
	public List<Curso> traerCursos();
	
	@GET
	@Path("/detalle/{id}")
	public Curso traerCurso(@PathParam("id") Integer id);
	
	@POST
	@Path("/nuevo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Curso crearCurso(Curso c);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Curso modificarCurso(Curso c);
	
	@DELETE
	@Path("/{id}")
	public Curso borrarCurso(@PathParam("id") Integer id);
}
