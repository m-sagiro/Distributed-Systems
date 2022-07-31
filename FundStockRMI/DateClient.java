package FundStockRMI;

import java.rmi.Naming;
import java.util.HashSet;

public class DateClient {
  public static void main (String[] args) throws Exception {
    if (args.length != 1)
      throw new IllegalArgumentException ("Syntax: DateClient <hostname>");
          
    try {
        Fund fund1 = (Fund) Naming.lookup("rmi://" + args[0] + "/fundServer1");
        System.out.println(fund1.getFundName());

        Fund fund2 = (Fund) Naming.lookup("rmi://" + args[0] + "/fundServer2");
        System.out.println(fund2.getFundName());

        fund1.addStock("stock1", (float) 5.5, 10);
        fund1.addStock("stock2", (float) 3.5, 3);
        fund1.addStock("stock3", (float) 2.5, 3);

        fund2.addStock("stock4", (float) 3.3, 11);
        fund2.addStock("stock5", (float) 6.6, 18);
        fund2.addStock("stock6", (float) 4.4, 5);

        Stock stock1 = fund1.getStockByName("stock2");
        System.out.println("Got stock1 from fund1:\nName: " + stock1.getStockName() +
                " divident: " + stock1.getStockDividend() + " quantity " + stock1.getStockQuantity());

        Stock stock5 = fund2.getStockByName("stock5");
        System.out.println("Got stock5 from fund2:\nName: " + stock5.getStockName() +
                " divident: " + stock5.getStockDividend() + " quantity " + stock5.getStockQuantity());

        System.out.println("\nChanging stock5 quantity and printing again\n");
        stock5.setStockQuantity(99);
        System.out.println("Got stock5 from fund2:\nName: " + stock5.getStockName() +
                " divident: " + stock5.getStockDividend() + " quantity " + stock5.getStockQuantity());

        System.out.println("\n Printing fund names: " + fund1.getFundName() + " " + fund2.getFundName());

        HashSet<Stock> fund1_all_stocks = fund1.getAllStocks();
        System.out.println("_________\nPrinting all Stock objects of fund1:\n");
        for(Stock i: fund1_all_stocks){
            System.out.print(i.getStockName()+"\n");
        }

        int counter = 0;

        for(Stock i: fund1_all_stocks){
            if(i.getStockDividend()>5){
                counter++;
            }
        }

        System.out.println("There are " + counter + " stocks with greater dividend than 5 in fund1");
        
    } catch (Exception e) {
		System.out.println("DateClient: " + e.getMessage());
	    e.printStackTrace();
	}
    
  }
}
