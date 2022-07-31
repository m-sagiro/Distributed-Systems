package FundStockRMI;

import java.rmi.*;
import java.rmi.server.*;
import java.util.HashSet;

class FundServerImpl extends UnicastRemoteObject implements Fund {
  private String name;
  HashSet<Stock> stocks = new HashSet<Stock>();

  public FundServerImpl (String name) throws RemoteException {
    this.name = name;
  }


  public static void main (String[] args) {

    try {
      FundServerImpl fundServer1 = new FundServerImpl ("fund1");
      FundServerImpl fundServer2 = new FundServerImpl ("fund2");

      Naming.rebind ("fundServer1", fundServer1);
      Naming.rebind ("fundServer2", fundServer2);
      System.out.println("The server is up. Two funds are registered!");
      System.out.println("fund1 and fund2");
      
    } catch (Exception e) {
		System.out.println("DateServerImpl: " + e.getMessage());
		e.printStackTrace();
	}
  }

  @Override
  public Stock getStockByName(String name) throws RemoteException {
    for(Stock stock: stocks){
      if(stock.getStockName().equals(name)){
        return stock;
      }
    }
    return null;
  }

  @Override
  public void addStock(String name, float divident, int quantity) throws RemoteException {
    StockServerImpl stock = new StockServerImpl(name, divident, quantity);
    stocks.add(stock);
  }

  @Override
  public HashSet<Stock> getAllStocks() throws RemoteException {
    return stocks;
  }

  @Override
  public String getFundName() throws RemoteException {
    return name;
  }
}

class StockServerImpl extends UnicastRemoteObject implements Stock {
  private String name;
  private float dividend;
  private int quantity;

  public StockServerImpl(String name, float divident, int quantity) throws RemoteException{
    this.name = name;
    this.dividend = divident;
    this.quantity = quantity;
  }

  public static void main (String[] args) {

    try {
      //StockServerImpl stockServer = new StockServerImpl ();
      //StockServerImpl stockServer1 = new StockServerImpl()

      //Naming.rebind ("DateServer", stockServer);
      //System.out.println("The server is up");

    } catch (Exception e) {
      System.out.println("DateServerImpl: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public String getStockName() throws RemoteException {
    return name;
  }

  @Override
  public float getStockDividend() throws RemoteException {
    return dividend;
  }

  @Override
  public int getStockQuantity() throws RemoteException {
    return quantity;
  }

  @Override
  public void setStockQuantity(int quantity) throws RemoteException {
    this.quantity = quantity;
  }
}
