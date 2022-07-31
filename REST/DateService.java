package REST;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path( "DS" )
public class DateService {

  @GET
  @Produces( MediaType.TEXT_PLAIN )          
  public String getDate() {
    return new Date().toString();
  }
  
  @GET 
  @Produces( MediaType.TEXT_HTML )
  public String getDateHTML() {
    return "<html><title>Date</title><body><h2>HTML: " + new Date().toString() + "</h2></body></html>";
  }
  
  @GET 
  @Produces(MediaType.TEXT_XML) 
  public String getDateXML() { 
      return "<?xml version=\"1.0\"?><date>" + new Date().toString() + "</date>"; 
  } 
  
  @Path( "/extra" )
  @GET 
  @Produces(MediaType.TEXT_PLAIN) 
  public String getDateExtra() { 
      return "The current date is: " + new Date().toString(); 
  } 
    
}