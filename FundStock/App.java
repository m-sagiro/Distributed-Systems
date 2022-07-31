package FundStock;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        Fund fund1 = new Fund("fund1");
        fund1.addStock("stock1", (float) 5.5, 100);
        fund1.addStock("stock2", (float) 6.9, 150);
        fund1.addStock("stock3", (float) 9.5, 100);
        fund1.addStock("stock4", (float) 11.9, 200);
        fund1.addStock("stock5", (float) 3.5, 300);
        fund1.addStock("stock6", (float) 6.9, 400);

        HashSet<Stock> stocks1 = fund1.getAllStocks();
        int counter=0;
        for(Stock stock: stocks1){
            if(stock.getStockDividend()>5.0){
                counter+=stock.getStockQuantity();
            }
        }
        System.out.println(counter);

        System.out.println(fund1.getStockByName("stock2").getStockName());
    }
}
