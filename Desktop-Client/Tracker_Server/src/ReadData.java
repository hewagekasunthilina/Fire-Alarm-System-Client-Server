import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;
import java.util.Timer;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

public class ReadData extends UnicastRemoteObject implements Server_Remort_INF
{
	public static String reciever = "kasunthilina1000@gmail.com"; 
	public static String PHONE_NUMBER = "+940770828319";
    public static String ACCOUNT_SID = "ACd331edac76afbd72c6980c38b89f4af9";
	public static String AUTH_TOKEN = "eb9b5918e7d0a6e82208dd2aa6afa26e";
	public static String mymail = "firealer@logan.baiscopehosting.com";
	
	protected ReadData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readTemp() throws RemoteException {
		
		String output = null;
		
		try {

            URL url = new URL("https://www.firealermmonitoring.baishost.com/status.php"); // Data Retrieve URL
            HttpURLConnection connectionURL = (HttpURLConnection) url.openConnection();
            connectionURL.setRequestMethod("GET");
            connectionURL.setRequestProperty("Content-Type", "application/json");
            connectionURL.setRequestProperty("Accept", "application/json");
            
            //Error Handling
            if (connectionURL.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "+ connectionURL.getResponseCode());
            }
            
            //Response Reading
            InputStreamReader in = new InputStreamReader(connectionURL.getInputStream());
            BufferedReader br = new BufferedReader(in);
            output = br.readLine();

            connectionURL.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
		
		return output;
	}

	public void sendSMS (String messageBody) throws Exception {
	
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	
		com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
				new PhoneNumber(PHONE_NUMBER),
				new PhoneNumber("+13343423500"),
				messageBody).create();	 
	}
	
	public static void sendMail(String reciever, String messageBody) {
		System.out.println(" In the mail method");
		
	      Properties properties = System.getProperties(); 
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", "465");
	      properties.put("mail.smtp.ssl.enable", "true");
	      properties.put("mail.smtp.auth", "true");

	      Session session = Session.getDefaultInstance(properties, new Authenticator() {
		  
	    	protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mymail, "DistributedSystem");
			}
	      }); 
	           
	      session.setDebug(true);

		 try 
	      { 

	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(mymail)); 
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever)); 
	         message.setSubject("Emergency Fire Alart!"); 
	         message.setText(messageBody); 
	         Transport.send(message); 
	         System.out.println("E-Mail Sent!"); 

	      } 
	      catch (MessagingException mex)  
	      { 
	         mex.printStackTrace(); 
	      } 

	}
	

	@Override
	public void sendMYAlert(String messageBody)
	{

		System.out.println(messageBody);
		
		sendMail(reciever, messageBody);
		
	}

	@Override
	public void addMYSensor(int DeviceID, int floorNo, String roomNo) throws RemoteException {
		// TODO Auto-generated method stub

				String POST_PARAMS = "{\n" + "\"device_id\":"+"\""+DeviceID+"\",\r\n" 
						+ "\"device_floor\":"+"\""+floorNo+"\",\r\n" 
						+
				        "    \"device_room\":"+"\""+roomNo+"\",\r\n" 
						+
				        "    \"device_smoke\":"+"\""+0+"\",\r\n" 
						+
				        "    \"device_co2\":"+"\""+0+"\",\r\n" 
						+
				        "	\"device_status\": \"Deactive\"" + "\n}";
				
				try {
					URL url = new URL("https://www.firealermmonitoring.baishost.com/sentStatues.php"); //POST URL
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");
					conn.setRequestProperty("Accept", "application/json");
					conn.setDoOutput(true);

					OutputStream outputStream = conn.getOutputStream();
					outputStream.write(POST_PARAMS.getBytes());
					outputStream.flush();
					outputStream.close();

					int responseCode = conn.getResponseCode();
				    System.out.println("POST Response Code :  " + responseCode);
				    System.out.println("POST Response Message : " + conn.getResponseMessage());
				    System.out.println("Fire Alarm Added Successfully");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	
	

	
}