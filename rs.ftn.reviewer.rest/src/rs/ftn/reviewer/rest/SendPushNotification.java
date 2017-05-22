package rs.ftn.reviewer.rest;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class SendPushNotification {
	
	public final static String AUTH_KEY_FCM = "AIzaSyBNX2j-0H1Jm5K9hKyemDk76f43m5NTmng";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	// userDeviceIdKey is the device id you will query from your database

	public static void pushFCMNotification(String userDeviceIdKey) throws Exception{

	   String authKey = AUTH_KEY_FCM; // You FCM AUTH key
	   String FMCurl = API_URL_FCM; 

	   URL url = new URL(FMCurl);
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	   conn.setUseCaches(false);
	   conn.setDoInput(true);
	   conn.setDoOutput(true);

	   conn.setRequestMethod("POST");
	   conn.setRequestProperty("Authorization","key="+authKey);
	   conn.setRequestProperty("Content-Type","application/json");

	   JSONObject json = new JSONObject();
	   json.put("to","/topics/"+userDeviceIdKey.trim());
	   JSONObject info = new JSONObject();
	   info.put("title", "Notificatoin Title"); // Notification title
	   info.put("body", "Hello Test notification"); // Notification body
	   json.put("notification", info);

	   OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	   wr.write(json.toString());
	   wr.flush();
	   conn.getInputStream();
	}
	
}
