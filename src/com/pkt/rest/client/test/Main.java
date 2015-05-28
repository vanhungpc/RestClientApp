package com.pkt.rest.client.test;

import java.lang.reflect.Type;
import java.util.List;
import java.io.*;  
import java.net.*;
import com.google.gson.reflect.TypeToken;
import com.pkt.rest.client.helper.JsonHelper;
import com.pkt.rest.client.pojo.Account;
import com.pkt.rest.client.services.AccountService;
import com.pkt.rest.client.services.CommentService;

public class Main {

	public static void main(String[] args) throws Exception{
		System.out.println("Hello world");

		// Account
		String accountsJson = AccountService.getInstance().getJsonString(
				AccountService._PATH);
		System.out.println(accountsJson);
		// String accountJson =
		// AccountService.getInstance().getJsonString(AccountService._PATH, 2);
		// System.out.println(accountJson);

//		 Get Account list
//		 Type typeOfT = new TypeToken<List<Account>>(){}.getType();
//		 Object object =
//		 JsonHelper.GetInstance().GetObjectUsingGson(accountsJson, typeOfT,
//		 "account");
//		 @SuppressWarnings("unchecked")
//		 List<Account> accounts = (List<Account>)object;
//		 System.out.println(accounts.get(0).getUserName());

		// Get account by id
		// Type typeOfT = new TypeToken<Account>(){}.getType();
		// Object object =
		// JsonHelper.GetInstance().GetObjectUsingGson(accountJson, typeOfT);
		// Account a = (Account)object;
		// System.out.println("Username: " + a.getUserName());

		// Comment
		// String commentsJson =
		// CommentService.getInstance().getsJsonString(CommentService._PATH);
		// System.out.println(commentsJson);
		// String commentJson =
		// CommentService.getInstance().getJsonString(CommentService._PATH, 2);
		// System.out.println(commentJson);

		// Post using json
		// Account a = new Account();
		// a.setEmail("email@email.com");
		// a.setId(1000);
		// a.setPassword("123456a@");
		// a.setUserName("pkt");
		// AccountService.getInstance().post(a, new
		// String[]{AccountService._PATH, "add"});

		// Post using form
		// AccountService.getInstance().post(
		// new String[] { AccountService._PATH, "add", "form" },
		// new String[] { "100", "pkt", "123456a@", "email@email.com" },
		// new String[] { "id", "username", "password", "email" });

		// Put using json
		// Account a = new Account();
		// a.setUserName("binh city");
		// a.setPassword("123456789");
		// a.setFirtName("binh");
		// a.setLastName("nguyen");
		// a.setBirthDay("22/8/1989");
		// a.setCountry("viet nam");
		// a.setCity("thanh pho");
		// a.setPhoneNumber(123456);
		// a.setEmail("email@email.com");
		// a.setId(1000);
		// AccountService.getInstance().put(a);
		
		
//		Account acc = new Account();
//		acc.setUserName("vanhungpc");
//		acc.setPassword("123456");
//		acc.setBirthDay("22/5/2014");
//		acc.setAddress("thanh pho ho chi minh");
//		// acc.setPhoneNumber(edPhoneNumber.getText().toString());
//		acc.setEmail("vanhungpc@gmail.com");
//		boolean result = AccountService.getInstance().post(acc, new
//				 String[]{AccountService._PATH, "add"});
//		if(result){
//			System.out.println("OK");
//		}else{
//			System.out.println("err");
//		}
		
		HttpURLConnection conn = null;  
		  BufferedReader br = null;  
		  DataOutputStream dos = null;  
		  DataInputStream inStream = null;  
		  
		  InputStream is = null;  
		  OutputStream os = null;  
		  boolean ret = false;  
		  String StrMessage = "";  
		  String exsistingFileName = "F:\\image\\img1.png";  
		  
		  String lineEnd = "\r\n";  
		  String twoHyphens = "--";  
		  String boundary =  "*****";  
		  
		  
		  int bytesRead, bytesAvailable, bufferSize;  
		  
		  byte[] buffer;  
		  
		  int maxBufferSize = 1*1024*1024;  
		  
		  
		  String responseFromServer = "";  
		  
		 String urlString = "http://192.168.0.100:8080/RestService_SFC/file/upload";  
		  
//		  String urlString = "http://dev.duleaf.com/dwe/index.php/events/uploadImage";
		  
		  try  
		  {  
		   //------------------ CLIENT REQUEST  
		  
		   FileInputStream fileInputStream = new FileInputStream( new  
		File(exsistingFileName) );  
		  
		   // open a URL connection to the Servlet   
		  
		   URL url = new URL(urlString);  
		  
		  
		   // Open a HTTP connection to the URL  
		  
		   conn = (HttpURLConnection) url.openConnection();  
		  
		   // Allow Inputs  
		   conn.setDoInput(true);  
		  
		   // Allow Outputs  
		   conn.setDoOutput(true);  
		  
		   // Don't use a cached copy.  
		   conn.setUseCaches(false);  
		  
		   // Use a post method.  
		   conn.setRequestMethod("POST");  
		  
		   conn.setRequestProperty("Connection", "Keep-Alive");  
		    
		   conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);  
		  
		   dos = new DataOutputStream( conn.getOutputStream() );  
		  
		   dos.writeBytes(twoHyphens + boundary + lineEnd);  
		   dos.writeBytes("Content-Disposition: form-data; name=\"upload\";"  
		      + " filename=\"" + exsistingFileName +"\"" + lineEnd);  
		   dos.writeBytes(lineEnd);  
		  
		     
		  
		   // create a buffer of maximum size  
		  
		   bytesAvailable = fileInputStream.available();  
		   bufferSize = Math.min(bytesAvailable, maxBufferSize);  
		   buffer = new byte[bufferSize];  
		  
		   // read file and write it into form...  
		  
		   bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
		  
		   while (bytesRead > 0)  
		   {  
		    dos.write(buffer, 0, bufferSize);  
		    bytesAvailable = fileInputStream.available();  
		    bufferSize = Math.min(bytesAvailable, maxBufferSize);  
		    bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
		   }  
		  
		   // send multipart form data necesssary after file data...  
		  
		   dos.writeBytes(lineEnd);  
		   dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);  
		  
		   // close streams  
		  
		   fileInputStream.close();  
		   dos.flush();  
		   dos.close();  
		  
		  
		  }  
		  catch (MalformedURLException ex)  
		  {  
		   System.out.println("From ServletCom CLIENT REQUEST:"+ex);  
		  }  
		  
		  catch (IOException ioe)  
		  {  
		   System.out.println("From ServletCom CLIENT REQUEST:"+ioe);  
		  }  
		  
		  
		  //------------------ read the SERVER RESPONSE  
		  
		  
		  try  
		  {  
		   inStream = new DataInputStream ( conn.getInputStream() );  
		   String str;  
		   while (( str = inStream.readLine()) != null)  
		   {  
		    System.out.println("Server response is: "+str);  
		    System.out.println("");  
		   }  
		   inStream.close();  
		  
		  }  
		  catch (IOException ioex)  
		  {  
		   System.out.println("From (ServerResponse): "+ioex);  
		  
		  }  
		  
		  }  
	

}
