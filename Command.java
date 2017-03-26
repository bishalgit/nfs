import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Command extends Remote{
	String ls(String s) throws RemoteException;
}