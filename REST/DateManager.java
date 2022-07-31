package REST;

import FundStock.Fund;
import FundStock.Stock;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

@Path("/fund")
@Singleton
public class DateManager {

   Fund fund1 = new Fund("fund1");
   Fund fund2 = new Fund("fund2");

   @GET
   @Path("/getall/{fund}")
   @Produces(MediaType.APPLICATION_JSON)
   public HashSet<Stock> getAllStocks(@PathParam("fund") int fund){
      if(fund == 1) {
         return fund1.getAllStocks();
      }
      else{
         if(fund == 2) {
            return fund2.getAllStocks();
         }
         else{
            return null;
         }
      }
   }

   @GET
   @Path("/searchstock/{fund}/{stock}")
   @Produces(MediaType.APPLICATION_JSON)
   public Stock getStocksByName(@PathParam("fund") int fund, @PathParam("stock") String stock){
      if(fund == 1) {
         return fund1.getStockByName(stock);
      }
      else{
         if(fund == 2) {
            return fund2.getStockByName(stock);
         }
         else{
            return null;
         }
      }
   }

   @GET
   @Path("/addStock/{fund}/{stock}/{dividend}/{quantity}")
   @Produces(MediaType.APPLICATION_JSON)
   public String addStock(@PathParam("fund") int fund,
                          @PathParam("stock") String stock,
                          @PathParam("quantity") int quantity,
                          @PathParam("dividend") String dividend){
      float dvd = Float.parseFloat(dividend);
      if(fund == 1) {
         fund1.addStock(stock, dvd, quantity);
         return "Successfull added to fund1";
      }
      else{
         if(fund == 2) {
            fund2.addStock(stock, dvd, quantity);
            return "Successfull added to fund2";
         }
         else{
            return null;
         }
      }
   }

   @GET
   @Path("/changeStock/{fund}/{stock}/{quantity}")
   @Produces(MediaType.APPLICATION_JSON)
   public String changeStockQuantity(@PathParam("fund") int fund,
                          @PathParam("stock") String stock,
                          @PathParam("quantity") int quantity){
      if(fund == 1) {
         fund1.getStockByName(stock).setStockQuantity(quantity);
         return "Successfull changed quantity of fund1";
      }
      else{
         if(fund == 2) {
            fund2.getStockByName(stock).setStockQuantity(quantity);
            return "Successfull changed quantity of fund2";
         }
         else{
            return null;
         }
      }
   }
}