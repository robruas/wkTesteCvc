package br.com.cvc.servidor;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ResourceConfig config = new ResourceConfig().packages("br.com.cvc");
		URI uri = URI.create("http://localhost:8085/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("Servidor rodando");
		System.in.read();
		server.stop();
		//Teste Commit Git teste 2
	}

}
