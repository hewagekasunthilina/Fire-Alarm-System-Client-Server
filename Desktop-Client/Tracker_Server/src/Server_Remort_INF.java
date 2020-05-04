import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface Server_Remort_INF  extends Remote
{
	public String readTemp() throws RemoteException;
	public void addMYSensor(int DeviceID,int floorNo, String roomNo) throws RemoteException;
	public void sendMYAlert(String messageBody) throws RemoteException;
	
}
