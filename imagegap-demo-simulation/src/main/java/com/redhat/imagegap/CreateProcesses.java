package com.redhat.imagegap;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class CreateProcesses
{
	
    public static String server = "http://localhost:8080/business-central/";
    public static String username = "bpmAdmin";
    public static String password = "bpmsuite1!";
    public static String deploymentId = "com.redhat.demos:ImageGapAnalysis:1.0";
    public static String processId = "MortgageApplication.ImageGapProcess";
    public enum Http{GET,POST};

	public static void main(String[] args)
	{
		/*if( args.length < 2 || args.length > 4 )
		{
			System.out
					.println( "Usage: java -jar jboss-mortgage-demo-client.jar username password [http://localhost:8080/business-central [com.redhat.bpms.examples:mortgage:1]]" );
			return;

		}

		String userId = args[0];
		String password = args[1];
		 */
		
		String userId = "bpmAdmin";
		String password = "bpmSuite1!";

		String applicationContext;
		if( args.length > 2 )
		{
			applicationContext = args[2];
		}
		else
		{
			applicationContext = "http://localhost:8080/business-central";
		}

		String deploymentId;
		if( args.length > 3 )
		{
			deploymentId = args[3];
		}
		else
		{
			deploymentId = "com.redhat.demos:ImageGapAnalysis:1.0";
		}

		//populateSamples( userId, password, applicationContext, deploymentId );
		CreateProcesses.simulateProcesInstances();
	}

	public static void simulateProcesInstances()
	{

		try{
		
			String paramsString, url;
			/*Map<String, String> params = new HashMap<String, String>();
	    	
	    	params.put("movieEpisodeName", "Batman");
	    	params.put("airDate", "'2009'");
	    	params.put("releaseYear", "'1977'");
	    	params.put("country", "'USA'");*/
	    	
	    	paramsString = "?map_airDate='2008'&map_movieEpisodeName=Skyfall&map_country='USA'&map_releaseYear='1977'";
	    	url = "rest/runtime/"+deploymentId+"/process/"+processId+"/start"+paramsString;
	    	System.out.println("url: " + url);
	    	send("POST", url);
	    	
	    	paramsString = "?map_airDate='2009'&map_movieEpisodeName=Pi&map_country='USA'&map_releaseYear='1977'";
	    	url = "rest/runtime/"+deploymentId+"/process/"+processId+"/start"+paramsString;
	    	System.out.println("url: " + url);
	    	send("POST", url);
	    	
	    	paramsString = "?map_airDate='2010'&map_movieEpisodeName=emiti&map_country='USA'&map_releaseYear='1977'";
	    	url = "rest/runtime/"+deploymentId+"/process/"+processId+"/start"+paramsString;
	    	System.out.println("url: " + url);
	    	send("POST", url);
	    	
	    	paramsString = "?map_airDate='2012'&map_movieEpisodeName=vunda&map_country='USA'&map_releaseYear='1977'";
	    	url = "rest/runtime/"+deploymentId+"/process/"+processId+"/start"+paramsString;
	    	System.out.println("url: " + url);
	    	send("POST", url);
	    	
	    	paramsString = "?map_airDate='2015'&map_movieEpisodeName=lincoln&map_country='USA'&map_releaseYear='1977'";
	    	url = "rest/runtime/"+deploymentId+"/process/"+processId+"/start"+paramsString;
	    	System.out.println("url: " + url);
	    	send("POST", url);
	    	
	    	paramsString = "?map_airDate='2015'&map_movieEpisodeName=&map_country='USA'&map_releaseYear='1977'";
	    	url = "rest/runtime/"+deploymentId+"/process/"+processId+"/start"+paramsString;
	    	System.out.println("url: " + url);
	    	send("POST", url);
	    	
		}
		catch (HttpException e) {
            e.printStackTrace();
        }

	}
	
	
	private static String send(String httpType, String url) throws HttpException{
		
		RequestSpecification rs=
				given().redirects().follow(true)
				.auth().preemptive().basic(username,password)
				.when();
		Response response;
		if (httpType.equals("POST")){
			response = rs.post(server+url);
		}
		else 
		{
			response  = rs.get (server+url);
		}
		
		
		if (response.getStatusCode()!=200)
			throw new HttpException("Failed to "+httpType+" to "+url+" - http status line = "+ response.getStatusLine() +"; response content = "+ response.asString());
		
		// add the status line for info/debugging purposes
		String result=response.asString();

		return result;
	}
	
	private static String mapToQueryString(Map<String,String> params){
		StringBuffer sb=new StringBuffer();
		for(Map.Entry<String, String> e:params.entrySet()){
			sb.append("&map_"+e.getKey()+"="+e.getValue());
      
			/*if (Integer.class.isAssignableFrom(e.getValue().getClass()))
        		sb.append("i"); // force the Integer data type once its been received by Jbpm server
      		if (Long.class.isAssignableFrom(e.getValue().getClass()))
        		sb.append("l"); // force the Long data type once its been received by Jbpm server
        	*/
		}
		
		if (sb.length()>0)sb.replace(0,1,"?");
		System.out.println("sb.toString: " + sb.toString());
		return sb.toString();
	}
	

	private static Map<String, Object> getProcessArgs(String movieEpisodeName, String airDate, String releaseYear, String country)
	{
		Map<String, Object> processVariables = new HashMap<String, Object>();
		
		processVariables.put("movieEpisodeName", movieEpisodeName);
		processVariables.put("airDate", airDate);
		processVariables.put("releaseYear", releaseYear);
		processVariables.put("country", country);
		
		//Equivalent of http://localhost:8080/jbpm-console/rest/runtime/com.redhat.bpms.examples:mortgage:1/process/com.redhat.bpms.examples.mortgage.MortgageApplication/start?map_name=Babak&map_address=12300%20Wilshire&map_ssn=333224449i&map_income=200000i&map_price=1000000i&map_downPayment=200000i&map_amortization=30i
		return processVariables;
	}
}
