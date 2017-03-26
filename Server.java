import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;

public class Server implements Command {
	private String path;

	public Server(String p) {
		path = p;
	}

	public String ls(String command) {
		//search how to list files and folders of given directory
		File directory = new File(path);
        
        //get all the files from a directory
        File[] fList = directory.listFiles();
		
		//convert the list into comma separated string
        String temp = "";
        for (int i = 0; i < fList.length; i++) {
        	if (i == (fList.length - 1)) {
        		temp += fList[i].getName();        		
        	}else {
        		temp += fList[i].getName() + ",";
        	}
        	//System.out.println(file.getName());
        }

		//return the string
        return temp; 
	}

	public static void main(String[] args) {
		
		try {
			Server obj = new Server("D:\\Photos");
			Command stub = (Command) UnicastRemoteObject.exportObject(obj, 0);

			// Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Command", stub);

            System.err.println("Server ready");
		} catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}