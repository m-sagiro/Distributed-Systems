package REST;

import javax.json.Json;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class DateClient {

    static final String BASE_URI = "http://localhost:9067/";

    public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target;

		System.out.println("Add STOCKS ################");

		target = client.target(BASE_URI).path("fund/addStock/1/stock1/5.5/99");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));


		target = client.target(BASE_URI).path("fund/addStock/1/stock2/7.5/23");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		target = client.target(BASE_URI).path("fund/addStock/1/stock3/3.5/44");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		target = client.target(BASE_URI).path("fund/addStock/2/stock1/3.3/43");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		target = client.target(BASE_URI).path("fund/addStock/2/stock2/6.7/67");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out.println("Bekomme alle STOCKS ################");

		target = client.target(BASE_URI).path("fund/getall/1");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		target = client.target(BASE_URI).path("fund/getall/2");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));


		System.out.println("Suche nach STOCKS ################");

		target = client.target(BASE_URI).path("fund/searchstock/1/stock1");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		target = client.target(BASE_URI).path("fund/searchstock/2/stock3");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));


		System.out.println("Change quantity ################");


		target = client.target(BASE_URI).path("fund/changeStock/1/stock1/300");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		target = client.target(BASE_URI).path("fund/changeStock/2/stock1/400");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		System.out.println("Bekomme alle STOCKS ################");

		target = client.target(BASE_URI).path("fund/getall/1");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		target = client.target(BASE_URI).path("fund/getall/2");
		invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));



		
//		  invocationBuilder = target.request(MediaType.TEXT_HTML);
//		  response = invocationBuilder.get();
//		  System.out.println(response.getStatus());
//		  System.out.println(response.readEntity(String.class));
//
//		  invocationBuilder = target.request(MediaType.TEXT_XML);
//		  response = invocationBuilder.get();
//		  System.out.println(response.getStatus());
//		  System.out.println(response.readEntity(String.class));
//
//		  target = client.target(BASE_URI).path("DS/extra");
//		  invocationBuilder = target.request(MediaType.TEXT_PLAIN);
//		  response = invocationBuilder.get();
//		  System.out.println(response.getStatus());
//		  System.out.println(response.readEntity(String.class));
    }
}