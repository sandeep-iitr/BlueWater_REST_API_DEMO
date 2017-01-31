/*
 * Developers: 
 * Sandeep Singh Sandha (UCLA: sandha.iitr@gmail.com)
 * Biplav Srivastava (IBM Research: biplavs@us.ibm.com)
 * 
 * Testing the BlueWater Rest API
 * BlueWater details: http://researcher.watson.ibm.com/researcher/view_group.php?id=6924
 * REST API details: http://researcher.watson.ibm.com/researcher/view_group_subpage.php?id=7142
 * 
 * This code released on:  31-Jan-2017
 */

package blueWater_java_src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Rest_Test_Main 
{
	static String REST_URL = "https://bluewater.mybluemix.net/query?";  
	/*This license key is only for testing purpose, generate your license key online at the below link
	 * https://bluewater.mybluemix.net/license.jsp
	 * */
	static String Lic_key="Lic=6VM2RzakD9";

	public static void main(String[] args) 
	{
		/*testing the spatial query*/
		spatial_query();
		
		/*testing the meta data query*/
		meta_places_query();
		
	}//end main
	
	/*Parameters to the REST include:
	 * Latitude
	 * Longitude
	 * Range (in meters)
	 * License key
	 * */
	static void spatial_query()
	{
		String query_par="Latitude=28.959731&Longitude=77.4782&Range=100&";
		String query_url=REST_URL+query_par+Lic_key;
		try
		{
		URL url = new URL(query_url);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");  
		con.getResponseCode();  
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		  String output;  
		  StringBuffer response = new StringBuffer();  
		  
		  while ((output = in.readLine()) != null) {  
		   response.append(output);  
		  }  
		  in.close();  
		  System.out.println("Spatial URL:"+query_url);
		  System.out.println("Spatial Response: "+response.toString()); 
		  
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}//end spatial_query
	
	
	/*Parameters to the REST include:
	 * Places-By-User (user id)
	 * Place-Type (manual or auto)
	 * License key
	 * */
	static void meta_places_query()
	{
		String query_par="Places-By-User=ibmadmin&Place-Type=manual&";
		String query_url=REST_URL+query_par+Lic_key;
		try
		{
		URL url = new URL(query_url);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");  
		con.getResponseCode();  
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		  String output;  
		  StringBuffer response = new StringBuffer();  
		  
		  while ((output = in.readLine()) != null) {  
		   response.append(output);  
		  }  
		  in.close();  
		  System.out.println("Meta URL:"+query_url);
		  System.out.println("Meta Response: "+response.toString()); 
		  
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}//end meta_places_query
	
}//end Rest_Test_Main
