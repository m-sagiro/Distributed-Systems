package REST;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class DateClient2 {

    static final String BASE_URI = "http://localhost:9067/";

    public static void main(String[] args) throws Exception {
      Client client = ClientBuilder.newClient();
		  WebTarget target = client.target(BASE_URI).path("DS");
		
		  Invocation.Builder invocationBuilder = target.request(MediaType.TEXT_PLAIN);
		  Response response = invocationBuilder.get();
		  System.out.println(response.getStatus());
		  System.out.println(response.readEntity(String.class));
		
		  invocationBuilder = target.request(MediaType.TEXT_XML);
		  response = invocationBuilder.get();
		  System.out.println(response.getStatus());
		  System.out.println(response.readEntity(String.class));
    }
}