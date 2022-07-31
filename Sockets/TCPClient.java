package Sockets;

import java.net.*;
import java.io.*;

public class TCPClient {
  public static void main (String args[]) {
  // args[0]: Message
  // args[1]: Server
  
    try{
		//server port and ip
		int serverPort = 7896;
		Socket s = new Socket (args[0], serverPort);
		ObjectOutputStream out1 = new ObjectOutputStream(s.getOutputStream());
		ObjectInputStream in1 = new ObjectInputStream ( s.getInputStream());

		//addStock
		String[] params1 = {"stock1", "5.7", "8"};
		Message addStock = new Message("addStock", "fund1", params1);
		//write object to server
		out1.writeObject(addStock);
		//read object from server
		Message response1 = (Message) in1.readObject();
		//print response
		System.out.println("Response: " + response1.getOperation());

		String[] params12 = {"stock2", "5.4", "99"};
		Message addStock2 = new Message("addStock", "fund2", params12);
		out1.writeObject(addStock2);
		Message response12 = (Message) in1.readObject();
		System.out.println("Response: " + response12.getOperation());


		//getStock
		String[] params2 = {};
		Message getStock = new Message("getStocks", "fund1", params2);
		out1.writeObject(getStock);
		Message response3 = (Message) in1.readObject();
		System.out.println("Printing all Stocks in fund1:______________________________________");
		for(String i: response3.getObjects()){
			System.out.println(i);
		}
		System.out.println("END:______________________________________");

		String[] params22 = {};
		Message getStock2 = new Message("getStocks", "fund2", params22);
		out1.writeObject(getStock2);
		Message response32 = (Message) in1.readObject();
		System.out.println("Printing all Stocks in fund2:______________________________________");
		for(String i: response32.getObjects()){
			System.out.println(i);
		}
		System.out.println("END:______________________________________");

		//getFund
		String[] params3 = {};
		Message getFund = new Message("getFund", "fund1", params3);
		out1.writeObject(getFund);
		Message response2 = (Message) in1.readObject();
		System.out.println("Response: " + response2.getF_name());

		String[] params33 = {};
		Message getFund3 = new Message("getFund", "fund2", params33);
		out1.writeObject(getFund3);
		Message response23 = (Message) in1.readObject();
		System.out.println("Response: " + response23.getF_name());


		//Verbindung beenden
		String[] params4 = {};
		Message END = new Message("END", "", params4);
		out1.writeObject(END);

		s.close();
    }catch (UnknownHostException e){
	  System.out.println(" Sock:"+ e.getMessage());
    }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
    }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());} catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
	}
  }// main
}// class