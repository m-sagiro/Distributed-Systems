package REST;

import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class DateServer2 {

    static final String BASE_URI = "http://localhost:9067/";

    public static void main(String[] args) throws Exception {
        HttpServer server = null ;

        ResourceConfig rc = new ResourceConfig(DateService2.class, DateManager.class);
        URI endpoint = new URI(BASE_URI);

        server = GrizzlyHttpServerFactory.createHttpServer(endpoint,rc);
        System.out.println("Press Enter to stop the server. ");
        System.in.read();
        server.shutdownNow();

    }
}