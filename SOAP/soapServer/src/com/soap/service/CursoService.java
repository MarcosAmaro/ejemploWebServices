package com.soap.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Use;

import com.soap.pojo.Curso;
import com.soap.pojo.ResponseStatus;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = Use.LITERAL)
public class CursoService {
	
	private static Map<Integer, Curso> cursos = cursosDB();

	public Curso getCurso(@WebParam(name = "id") int id) {
		return cursos.get(id);
	}

	public Collection<Curso> getCursos() {
		return cursos.values();
	}

	public ResponseStatus addCurso(@WebParam(name = "lenguaje") String leng,
			@WebParam(name = "precio") float p, @WebParam(name = "duracion") int d) {
		
		Integer id = Collections.max(cursos.keySet()) + 1;
		cursos.put(id, new Curso(id, leng, p, d));
		
		return new ResponseStatus(0, "Curso creado: " + id);
	}

	public ResponseStatus updateCurso(@WebParam(name = "id") int id, @WebParam(name = "lenguaje") String leng,
			@WebParam(name = "precio") float p, @WebParam(name = "duracion") int d) {
		
		if (!cursos.containsKey(id)) {
			return new ResponseStatus(100, "El curso " + id + " no existe");
		}

		cursos.put(id, new Curso(id, leng, p, d));
		return new ResponseStatus(0, "Curso modificado");
	}

	public ResponseStatus deleteCurso(@WebParam(name = "id") int id) {
		if (!cursos.containsKey(id)) {
			return new ResponseStatus(100, "El curso " + id + " no existe");
		}

		cursos.remove(id);
		return new ResponseStatus(0, "Curso borrado");
	}

	private static Map<Integer, Curso> cursosDB() {
		Map<Integer, Curso> db = new HashMap<Integer, Curso>();

		db.put(1, new Curso(1, "Java", 2000, 3));
		db.put(2, new Curso(2, "Erlang", 999.99F, 4));
		db.put(3, new Curso(3, "Python", 2121.22F, 2));

		return db;
	}

}
