package FundStock;

import java.rmi.Remote;
import java.util.*;

public class Fund implements Remote {
    private String name;
    //at most one Stock. Collection instead of Array used
    //Stock[] stocks;
    //Lieber ArrayList statt Array. Hashset auch ok
    HashSet<Stock> stocks = new HashSet<Stock>();

    public Fund(String name){
        this.name = name;
    }

    //min. 1 Stock mit dem Namen existiert
    public Stock getStockByName(String name){
        for(Stock stock: stocks){
            if(stock.getStockName().equals(name)){
                return stock;
            }
        }
        return null; //Null-Referenz bei Objekt-Rückgabe immer möglich
    }

    public void addStock(String name, float divident, int quantity) {
        Stock stock = new Stock(name, divident, quantity);
        stocks.add(stock);
    }

    public HashSet<Stock> getAllStocks() {
        return stocks;
    }

    public String getFundName() {
        return name;
    }
}
