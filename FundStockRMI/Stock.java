package FundStockRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Stock extends Remote{
    public String getStockName() throws RemoteException;

    public float getStockDividend() throws RemoteException;

    public int getStockQuantity() throws RemoteException;

    public void setStockQuantity(int quantity) throws RemoteException;
}
