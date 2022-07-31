package FundStockRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;

public interface Fund extends Remote {
    public Stock getStockByName(String name) throws RemoteException;

    public void addStock(String name, float divident, int quantity) throws RemoteException;

    public HashSet<Stock> getAllStocks() throws RemoteException;

    public String getFundName() throws RemoteException;
}
