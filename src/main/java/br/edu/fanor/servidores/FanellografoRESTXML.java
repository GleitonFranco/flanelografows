package br.edu.fanor.servidores;

import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXB;

@Path("consultasala")
public class FanellografoRESTXML {
	
	Flanelografo quadro = null;
	
	public FanellografoRESTXML() {
		quadro = Flanelografo.getInstance();
	}
	
	@GET
	@Path("{curso}")
	@Produces("application/xml")
	public String consultaSala(@PathParam("curso") String curso) {
		StringWriter writer = new StringWriter();
		JAXB.marshal(quadro.consultaSala(curso),writer);
		return writer.toString();
	}
}
