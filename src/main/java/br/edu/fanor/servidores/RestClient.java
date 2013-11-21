package br.edu.fanor.servidores;
import javax.xml.bind.JAXB;


public class RestClient {
	public static void main(String[] args) {
		new RestClient().vai();
		
	}

	private void vai() {
		String url = "http://localhost:8000/flanelografows/restful-services/consultasala/19";
//		ClientConfig config = new DefaultClientConfig();
//	    Client client = Client.create(config);
//	    WebResource service = client.resource(getBaseURI());
		System.out.println(url);
		String msg = JAXB.unmarshal(url, String.class);
//		JOptionPane.showMessageDialog((Component)this, msg, "consulta", JOptionPane.INFORMATION_MESSAGE);
		System.out.println(msg);
	}
}
