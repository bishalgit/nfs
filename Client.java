import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import java.util.Scanner;

public class Client {

	public Client() {

	}

	public static void main(String[] args) {
		//load remote object
		String line = null;
		String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Command stub = (Command) registry.lookup("Command");
        	
			while (true) {
				System.out.print("$\\");

				//input line mechanism banaune
				try{
					BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
					line = is.readLine();					
				}
				
				String data = stub.ls(line);
			}
		} catch(Exception e) {
			System.err.println("Client Exception: " + e.toString());
			e.printStackTrace();
		}
		//split string and print
	}
}