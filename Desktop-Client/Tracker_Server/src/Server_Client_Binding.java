import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server_Client_Binding
{
    public static void main(String[] args)  throws MalformedURLException, AlreadyBoundException {
        
    	try {
    		ReadData readData = new ReadData();		
    		Registry registry = LocateRegistry.createRegistry(1099);
    	    registry.rebind("MyServer", readData);

    		System.out.println("Server Started Successfully!");

    	} catch (RemoteException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }
}
