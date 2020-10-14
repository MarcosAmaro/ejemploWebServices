package com.soap.service;
import javax.xml.ws.Endpoint;

public class SoapService {
	
	public static void main(String[] args) {
		String url = "http://localhost:9000/CursoService"; //http://localhost:9000/CursoService
		Endpoint.publish(url, new CursoService());
		System.out.println("Servicios iniciado @ " + url);
	}
}
