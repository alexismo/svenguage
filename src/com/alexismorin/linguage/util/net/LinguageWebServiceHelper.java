package com.alexismorin.linguage.util.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EncodingUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import android.util.Log;

public class LinguageWebServiceHelper {
	private static final int HTTP_STATUS_OK = 200;
	private static byte[] buff = new byte[1024];
	
	public static String server_prefix, service_prefix;
	
	public String ticket;
	
	public LinguageWebServiceHelper(String serverPrefix){
		this.server_prefix = serverPrefix;
		//serverPrefix += "services/v1";
	}
	
	protected HttpGet doHttpGet(URL url) throws MalformedURLException{
        HttpGet httpGet = new HttpGet(url.toString());

        if(this.ticket != null){//always set the header if we have it
            httpGet.addHeader("x-ticket", this.ticket);
        }

        return httpGet;
    }
	
	protected HttpPost doHTTPPost(URL url, List<NameValuePair> postParams) throws UnsupportedEncodingException{                        
        HttpPost httpPost = new HttpPost(url.toString());
        if(postParams != null)
            httpPost.setEntity(new UrlEncodedFormEntity(postParams));

        if(this.ticket != null){//always set the header if we have it
            httpPost.addHeader("x-ticket", this.ticket);
        }else{
            Log.i("getHTTPPost","POST: Making request without ticket " + url.toString());
        }

        return httpPost;
    }

	
	protected synchronized String callService(String serviceName, List<NameValuePair> postParams, String method) throws MalformedURLException{
	    URL url = new URL(server_prefix+serviceName);
	    HttpParams httpParameters = new BasicHttpParams();
	    // Set the timeout in milliseconds until a connection is established.
	    // The default value is zero, that means the timeout is not used. 
	    int timeoutConnection = 3000;
	    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
	    // Set the default socket timeout (SO_TIMEOUT) 
	    // in milliseconds which is the timeout for waiting for data.
	    int timeoutSocket = 5000;
	    HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
	    HttpClient httpClient = new DefaultHttpClient(httpParameters);
	    
	    try{
	        HttpResponse response;
	        if(method.equals("post")){
	            response = httpClient.execute(doHTTPPost(url, postParams));
	        }else{
	            response = httpClient.execute(doHttpGet(url));
	        }
	        
	        int statusCode = response.getStatusLine().getStatusCode();
	        if(statusCode != 200){
	            Log.e("HTTP status",statusCode+"");
	        }
	        
	        return responseAsString(response);
	        
	    } catch (ClientProtocolException e) {
	        Log.i("VLOWSH", "CPE @ CallService");
	    } catch (IOException e){                                                                                                        
	        Log.i("VLOWSH", "IOE @ CallService");
	    }
	    return null;
	}

	public static String responseAsString(HttpResponse response) throws IOException {
    
	    StatusLine status = response.getStatusLine();
	    if(status.getStatusCode() != HTTP_STATUS_OK){
	        throw new IOException("Invalid response from server! " + status.toString());
	    }
	    
	    //do the herdy gerdy and convert the response to a String
	    InputStream ist = response.getEntity().getContent();
	    
	    ByteArrayOutputStream content = new ByteArrayOutputStream();
	    int readCount = 0;
	    while ((readCount = ist.read(buff)) != -1)
	        content.write(buff, 0, readCount);
	    
	    String thePagesContent = EncodingUtils.getString(content.toByteArray(), "UTF-8");
	    
	    return thePagesContent;
	}

	public FeedResponse getChallengesFeed() throws JsonSyntaxException, MalformedURLException{
		Gson gson = new Gson();
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(0);
		FeedResponse fr = gson.fromJson(callService("feed.json", nameValuePairs, "get"), FeedResponse.class);
		
		return fr;
	}
}
