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

// Defino a nivel global el path de la api
@Path("/cursos")
public interface CursoClient {

	@GET
	@Path("") //Vacio porque consulta el path de la api sin mas agregado => /cursos
	public List<Curso> traerCursos();
	
	@GET
	@Path("{id}") // => /cursos/{id}
	public Curso traerCurso(@PathParam("id") Integer id);
	
	@POST
	@Path("") // => /cursos
	@Consumes(MediaType.APPLICATION_JSON)
	public Curso crearCurso(Curso c);
	
	@PUT
	@Path("{id}") // => /cursos/{id}
	@Consumes(MediaType.APPLICATION_JSON)
	public Curso modificarCurso(@PathParam("id") Integer id, Curso c);
	
	@DELETE
	@Path("{id}") // => /cursos/{id}
	public Curso borrarCurso(@PathParam("id") Integer id);
}
