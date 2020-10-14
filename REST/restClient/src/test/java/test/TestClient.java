package test;

import java.util.List;


import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import pojo.Curso;
import rest.client.CursoClient;

public class TestClient {

	public static void main(String[] args) {
		ResteasyClient client = new ResteasyClientBuilderImpl().build();
		ResteasyWebTarget wt = client.target("http://192.168.43.129:5000");
		CursoClient cc = wt.proxy(CursoClient.class);
		
		List<Curso> cursos = cc.traerCursos();
		if (cursos != null) {
			for(Curso x : cursos) {
				System.out.println(x);
				System.out.println("*****************");
			}
		}
		
		System.out.println();
		System.out.println(cc.traerCurso(2));
		System.out.println("*****************");
		System.out.println(cc.traerCurso(6));
		System.out.println("*****************");
		System.out.println();
		
		Curso c = new Curso();
		c.setLenguaje("C# Sharp");
		c.setPrecio(1000);
		c.setDuracion(6);
		
		System.out.println(cc.crearCurso(c));
		System.out.println("*****************");
		System.out.println();
		
		c.setId(1);
		c.setLenguaje("SmallTalk");
		System.out.println(cc.modificarCurso(c));
		System.out.println("*****************");
		System.out.println();
		
		System.out.println(cc.borrarCurso(3));
		System.out.println("*****************");
		System.out.println();
		
		cursos = cc.traerCursos();
		if (cursos != null) {
			for(Curso x : cursos) {
				System.out.println(x);
				System.out.println("*****************");
			}
		}
	}

}
