package Sockets;

import FundStock.Fund;
import FundStock.Stock;

import java.net.*;
import java.io.*;
import java.util.HashSet;

public class TCPServer {

  public static void main (String args[]) {
      Fund fund1 = new Fund("fund1");
      Fund fund2 = new Fund("fund2");

    try{
      System.out.println("The Server is running");
	  int serverPort = 7896;
	  ServerSocket listenSocket = new ServerSocket (serverPort);
	  while(true) {
	    Socket clientSocket = listenSocket.accept();
	    System. out.println("New Connection");
	    Connection c = new Connection(clientSocket, fund1, fund2);
	  }
    } catch( IOException e) {System.out.println(" Listen :"+ e.getMessage());}
  }// main
}//class


class Connection extends Thread {
  ObjectInputStream in;
  ObjectOutputStream out;
  Socket clientSocket;
  Fund fund1;
  Fund fund2;


  public Connection (Socket aClientSocket, Fund fund1, Fund fund2) {
      this.fund1 = fund1;
      this.fund2 = fund2;
    try {
      clientSocket = aClientSocket;
      out = new ObjectOutputStream ( clientSocket.getOutputStream() );
      in = new ObjectInputStream ( clientSocket.getInputStream() );
      this.start();
    } catch( IOException e) {System. out. println(" Connection:"+ e.getMessage());}
  }

  public void run(){
    try {
        Message data = (Message) in.readObject();
        String[] params = data.getParams();
        String operation = data.getOperation();

        while(!operation.equals("END")) {


            switch (operation) {
                case "addStock":
                    String f_name = data.getF_name();
                    String name = params[0];
                    float dividend = (Float) Float.parseFloat(params[1]);
                    int quantity = (Integer) Integer.parseInt(params[2]);

                    if (f_name.equals("fund1")) {

                        fund1.addStock(name, dividend, quantity);
                        System.out.println("Stock added to fund1");
                        data.setOperation("Stock added successfully to fund1 \nStock name: " +
                                fund1.getStockByName(name).getStockName() + "\nStock quantity: " +
                                fund1.getStockByName(name).getStockQuantity() + "\nStock dividend: " +
                                fund1.getStockByName(name).getStockDividend());
                        out.writeObject(data);
                    } else {
                        fund2.addStock(name, dividend, quantity);
                        System.out.println("Stock added to fund2");
                        data.setOperation("Stock added successfully to fund2 \nStock name: " +
                                fund2.getStockByName(name).getStockName() + "\nStock quantity: " +
                                fund2.getStockByName(name).getStockQuantity() + "\nStock dividend: " +
                                fund2.getStockByName(name).getStockDividend());
                        out.writeObject(data);
                    }
                    break;
                case "getStocks":
                    String f_name2 = data.getF_name();
                    if (f_name2.equals("fund1")) {
                        HashSet<Stock> funds = fund1.getAllStocks();
                        for(Stock i: funds){
                            data.addObjects(i.getStockName()+" "+i.getStockDividend()+" "+i.getStockQuantity());
                        }
                        out.writeObject(data);
                        System.out.println("Returned list of all stocks in funds1");
                    } else {
                        HashSet<Stock> funds = fund2.getAllStocks();
                        for(Stock j: funds){
                            data.addObjects(j.getStockName()+" "+j.getStockDividend()+" "+j.getStockQuantity());
                        }
                        out.writeObject(data);
                        System.out.println("Returned list of all stocks in funds2");
                    }
                    break;
                case "getFund":
                    String f_name3 = data.getF_name();
                    if (f_name3.equals("fund1")) {
                        String fund_name = fund1.getFundName();
                        data.setF_name(fund_name);
                        out.writeObject(data);
                        System.out.println("Fund name returned");
                    } else {
                        String fund_name = fund2.getFundName();
                        data.setF_name(fund_name);
                        out.writeObject(data);
                        System.out.println("Fund name returned");
                    }
                    break;
                default:
                    System.out.println("Wrong operation");
                    break;
            }

            data = (Message) in.readObject();
            params = data.getParams();
            operation = data.getOperation();
            System.out.println(fund1.getAllStocks().size());
        }

    } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
    } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());} catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
  }
}