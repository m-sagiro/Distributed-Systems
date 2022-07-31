package REST;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path( "DS" )
public class DateService2 {

  @GET
  @Produces( MediaType.TEXT_PLAIN )          
  public String getDate() {
    Date d = new Date();
    MyDate md = new MyDate();
    md.hour = d.getHours();
    md.min = d.getMinutes();
    md.sec = d.getSeconds();
    return md.toString();
  }
  
  @GET
  @Produces( { MediaType.TEXT_XML, MediaType.APPLICATION_JSON } )          
  public MyDate getDateXML() {
    Date d = new Date();
    MyDate md = new MyDate();
    md.hour = d.getHours();
    md.min = d.getMinutes();
    md.sec = d.getSeconds();
    return md;
  }
  
   @GET
   @Path("/part/{partid}")
   @Produces(MediaType.TEXT_PLAIN)
   public String getTimePart(@PathParam("partid") String pid){
      Date d = new Date();
      if (pid.equals("hour")) return  "" + d.getHours();
      if (pid.equals("min")) return  "" + d.getMinutes();
      if (pid.equals("sec")) return  "" + d.getSeconds();
      return "illegal argument";
   }

   @GET
   @Path("/part2")
   @Produces(MediaType.TEXT_PLAIN)
   public String getTimePart2(@QueryParam("partid") String pid){
      Date d = new Date();
      if (pid.equals("hour")) return  "" + d.getHours();
      if (pid.equals("min")) return  "" + d.getMinutes();
      if (pid.equals("sec")) return  "" + d.getSeconds();
      return "illegal argument";
   }
   
}