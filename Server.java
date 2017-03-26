import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Command {
	String path = "D:\Photos";

	String ls() {
		//search how to list files and folders of given directory
		//convert the list into comma separated string
		//return the string
	}
}