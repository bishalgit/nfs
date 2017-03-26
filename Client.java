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
				} catch(Exception e) {
					System.err.println("IO Exception: " + e.toString());
					e.printStackTrace();
				}

				String data = stub.ls(line);
				
				//split string and print
				String[] directoryList = data.split(",");

				for (String temp : directoryList) {
					if (temp.split(".").length > 1) {
						//it is file
						System.out.print(temp + " \t");
					} else {
						//it is directory
						System.err.print(temp + " \t");
					}
					System.out.println();
				}
				System.out.println();
			}
		} catch(Exception e) {
			System.err.println("Client Exception: " + e.toString());
			e.printStackTrace();
		}
	}
}