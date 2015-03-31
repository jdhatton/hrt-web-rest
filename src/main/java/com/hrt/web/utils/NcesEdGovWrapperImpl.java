package com.hrt.web.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Maps;

public class NcesEdGovWrapperImpl implements NcesEdGovWrapper {

	private final String USER_AGENT = "Mozilla/5.0";
	
	public NcesEdGovWrapperImpl() {
		// TODO Auto-generated constructor stub
	}

	public String searchForDistricts(String zipCode) {
		
		
		System.out.println(" \n\n\n   zipCode =  " + zipCode);
		//
		// Call the web service to get the HTML containing the list of districts.
		//
       		
		Map<String,String> parameters = Maps.newHashMap();
		parameters.put("Search", "1");
		parameters.put("details", "1");
		parameters.put("InstName", "");
		parameters.put("DistrictID", "");
		parameters.put("Address", "");
		parameters.put("City", "");
		parameters.put("State", "");
		parameters.put("Zip", zipCode);
		parameters.put("Miles", "15");
		parameters.put("County", "");
		parameters.put("PhoneAreaCode", "");
		parameters.put("Phone", "");
		parameters.put("DistrictType", "1");
		parameters.put("DistrictType", "2");
		parameters.put("DistrictType", "3");
		parameters.put("DistrictType", "4");
		parameters.put("DistrictType", "5");
		parameters.put("DistrictType", "6");
		parameters.put("DistrictType", "7");
		parameters.put("NumOfStudents", "");
		parameters.put("NumOfStudentsRange", "more");
		parameters.put("NumOfSchools", "");
		parameters.put("NumOfSchoolsRange", "more");
		
		
//		HttpResponse webPage = WS.url("http://nces.ed.gov/ccd/districtsearch/district_list.asp").setParameters(parameters).post();
		
//		HttpResponse webPage = WS.url(fullURL).setParameters(parameters).post();
//		System.out.println("\n >>>  RESPONSE = \n  " + webPage.getString() );
//		
		HttpResponse webPage = execHttpRequest(zipCode);
		
		return webPage.toString();
	}

	public String searchForSchools(String districtName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private HttpResponse execHttpRequest(String zipCode){
	
		
		String url = "http://nces.ed.gov/ccd/districtsearch/district_list.asp";  // "https://selfsolve.apple.com/wcResults.do";
		HttpResponse response = null;
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
	 
		// add header	
		post.setHeader("User-Agent", USER_AGENT);
	 
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("Search", "1"));
		urlParameters.add(new BasicNameValuePair("details", "1"));
		urlParameters.add(new BasicNameValuePair("InstName", ""));
		urlParameters.add(new BasicNameValuePair("DistrictID", ""));
		urlParameters.add(new BasicNameValuePair("Address", ""));
		urlParameters.add(new BasicNameValuePair("City", ""));
		urlParameters.add(new BasicNameValuePair("State", ""));
		urlParameters.add(new BasicNameValuePair("Zip", zipCode));
		urlParameters.add(new BasicNameValuePair("Miles", "15"));
		urlParameters.add(new BasicNameValuePair("County", ""));
		urlParameters.add(new BasicNameValuePair("PhoneAreaCode", ""));
		urlParameters.add(new BasicNameValuePair("Phone", ""));
		urlParameters.add(new BasicNameValuePair("DistrictType", "1"));
		urlParameters.add(new BasicNameValuePair("DistrictType", "2"));
		urlParameters.add(new BasicNameValuePair("DistrictType", "3"));
		urlParameters.add(new BasicNameValuePair("DistrictType", "4"));
		urlParameters.add(new BasicNameValuePair("DistrictType", "5"));
		urlParameters.add(new BasicNameValuePair("DistrictType", "6"));
		urlParameters.add(new BasicNameValuePair("DistrictType", "7"));
		urlParameters.add(new BasicNameValuePair("NumOfStudents", ""));
		urlParameters.add(new BasicNameValuePair("NumOfStudentsRange", "more"));
		urlParameters.add(new BasicNameValuePair("NumOfSchools", ""));
		urlParameters.add(new BasicNameValuePair("NumOfSchoolsRange", "more"));
		
	 
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
 
			response = client.execute(post);
			System.out.println("Response Code : "  + response.getStatusLine().getStatusCode());
 
			BufferedReader rd = new BufferedReader(
			        new InputStreamReader(response.getEntity().getContent()));
 
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			System.out.println(" RESULT =  \n\n "+result.toString());
			//File file = new File("/home/jdhatton/devenv/results.html");
			
		} catch (UnsupportedEncodingException e) {			 
			e.printStackTrace();
		} catch (ClientProtocolException e) {			 
			e.printStackTrace();
		} catch (IllegalStateException e) {			 
			e.printStackTrace();
		} catch (IOException e) {			 
			e.printStackTrace();
		}
		return response;
		
	}
		 

}
