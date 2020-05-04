import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TestSMS {

	public static void myTest() throws Exception{
		// TODO Auto-generated method stub
		String message = "Hi, Please Note That the CO2 level has Increased. This May Cause an Emergency Situation!";		
		String phone = "+94770828319";
		String username = "abcd";
		String password = "1234";
		String address = "http://192.168.1.242";
		String port = "1099";

		URL url = new URL(
				address+":"+port+"/SendSMS?username="+username+"&password="+password+
				"&phone="+phone+"&message="+URLEncoder.encode(message,"UTF-8"));
		
		URLConnection connection = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while((inputLine = bufferedReader.readLine()) !=null){
			System.out.println(inputLine);
		}
		bufferedReader.close();
		

	}

}


