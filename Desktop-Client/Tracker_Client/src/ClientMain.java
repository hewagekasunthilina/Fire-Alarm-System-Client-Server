import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


import newpack.AllData;

public class ClientMain {
	
	static Server_Remort_INF Server_remort;
	public static ArrayList<AllData> initialList;

	public static ArrayList<AllData> TempAdd_Grid(){
		
		ArrayList<AllData> floorDetails = new ArrayList<AllData>();
		
		try {

			Server_remort =(Server_Remort_INF) Naming.lookup("rmi://localhost:1099/MyServer"); //access read rest api method in server
			String output = Server_remort.readTemp();
			
			JSONArray  jarr = new JSONArray(output);
			
			for (int i = 0; i < jarr.length(); i++) {
				
				AllData All_Flor_Details = new AllData();
				
				  JSONObject obj = jarr.getJSONObject(i);
				  
				  	All_Flor_Details.setId(obj.getInt("id"));
					All_Flor_Details.setDevice_id(obj.getInt("device_id"));
					All_Flor_Details.setDevice_status(obj.getString("device_status"));
					All_Flor_Details.setDevice_floor(obj.getInt("device_floor"));
					All_Flor_Details.setDevice_room(obj.getInt("device_room"));
					All_Flor_Details.setDevice_smoke(obj.getInt("device_smoke"));
					All_Flor_Details.setDevice_co2(obj.getInt("device_co2"));
				  
					floorDetails.add(All_Flor_Details); 
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return floorDetails;
	}
	
	public void sendMYAlert()
	{
		
		ArrayList<AllData> list = TempAdd_Grid();
		String alertMessage = "";
		
		for(int i = 0; i < list.size(); i++) {
			
			int id = list.get(i).getId();

			if((list.get(i).getDevice_co2() >= 5) || (list.get(i).getDevice_smoke() >= 5)) {
				
				
				if(!initialList.stream().filter(o -> o.getId() == id).findFirst().isPresent()) {
					alertMessage = alertMessage + "FloorNo: " + list.get(i).getDevice_floor() + "\nRoomNo: " + list.get(i).getDevice_room() + 
							"\nCO2Level: " + list.get(i).getDevice_co2() + "\nSmokeLevel: " + list.get(i).getDevice_smoke() + "\n\n";
					
					initialList.add(list.get(i));
				}
			}
			else {

				if(initialList.stream().filter(o -> o.getId() == id).findFirst().isPresent()) {
					
					int j = 0;
					
					while(initialList.get(j).getId() != id) {
						j++;
					}
					
					initialList.remove(j);
				}
			}
			
		}
	}

	
	public void AddMore(String DeviceId,String roomNo, String floorNumber) {
		
		try {
			Server_remort =(Server_Remort_INF) Naming.lookup("rmi://localhost:1099/MyServer"); //access read rest api method in server
			
			
			Server_remort.addMYSensor(Integer.parseInt(DeviceId),Integer.parseInt(floorNumber), roomNo);
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void sendInitialAlert(ArrayList<AllData> alertList) {
		System.getProperty("java.security.policy");
		String alertMessage = "";
		initialList = alertList;
		
		try {
			Server_remort =(Server_Remort_INF) Naming.lookup("rmi://localhost:1099/MyServer");
			
			if(initialList.size() > 0) {
			
				for(int i = 0; i < initialList.size(); i++) {
					alertMessage = alertMessage + "FloorNo: " + initialList.get(i).getDevice_floor()+ "\nRoomNo: " + initialList.get(i).getDevice_room() + 
							"\nCO2Level: " + initialList.get(i).getDevice_co2() + "\nSmokeLevel: " + initialList.get(i).getDevice_smoke() + "\n\n";
				}
				
				Server_remort.sendMYAlert(alertMessage);
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
