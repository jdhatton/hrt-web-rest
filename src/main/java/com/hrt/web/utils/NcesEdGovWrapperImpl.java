package com.hrt.web.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jersey.repackaged.com.google.common.collect.Lists;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Maps;
import com.hrt.data.db.beans.District;

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

//		System.out.println("\n >>>  RESPONSE = \n  " + webPage.getString() );
 		
		String webPage = execHttpRequest(zipCode);
		
		
		parseHtml(webPage);
		
		return webPage;
	}

	public String searchForSchools(String districtName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private String execHttpRequest(String zipCode){
	
		
		String url = "http://nces.ed.gov/ccd/districtsearch/district_list.asp";  // "https://selfsolve.apple.com/wcResults.do";
		HttpResponse response = null;
		StringBuffer result = new StringBuffer();
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
//			System.out.println("Response Code : "  + response.getStatusLine().getStatusCode());
 
			BufferedReader rd = new BufferedReader(
			        new InputStreamReader(response.getEntity().getContent()));
 			
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
//			System.out.println(" RESULT =  \n\n "+result.toString());
			
		} catch (UnsupportedEncodingException e) {			 
			e.printStackTrace();
		} catch (ClientProtocolException e) {			 
			e.printStackTrace();
		} catch (IllegalStateException e) {			 
			e.printStackTrace();
		} catch (IOException e) {			 
			e.printStackTrace();
		}
		return result.toString();
		
	}
	
	/**
	 * Method to parse out the relevant info for Districts.
	 * @param html
	 */
	protected List<District> parseHtml(String html) {
		
		Document doc = null;
		List<District> districts = Lists.newArrayList();
		try {			 
			doc =Jsoup.parse(html);
		} catch (Exception e) {
			//
			// TODO: don't eat exceptions, do something with this.
			//
			e.printStackTrace();
		}
		System.out.println("\n>> Dumping HTML Table info \n");
        for (Element table : doc.select("table")) {
        	String data = table.text();       	
        	 
        	if( data.length() > 0){
	        	if( Character.isDigit(data.charAt(0))){
		        	for (Element row : table.select("tr")) {
		        		System.out.println(">>>   ");
		                Elements tds = row.select("td");
		                if(tds != null && tds.size() > 0){
		                	int counter =0, numRows = 9;
		                	District district = new District();
		                	for(Element td : tds){
		                		//System.out.println(">>>    <TD>  = " + td.html() ); 
		                		
		                		Document districtTD =Jsoup.parse(td.html());		                		
		                		for (Element href : districtTD.select("a")) {
		                        	String link = "http://nces.ed.gov/ccd/districtsearch/"+href.attr("href");
		                        	System.out.println(">>>    <a>  = " + link); 
		                		}	
		                		for (Element font : districtTD.select("font")) {
		                        	//String dfont = font.text();
		                        	System.out.println(">>>    <font>  = " + font.text()); 
		                        	Document fontDoc =Jsoup.parse(font.html());
		                		}
		                		for (Element strong : districtTD.select("strong")) {
		                        	//String dstrong = strong.text();
		                        	System.out.println(">>>    <strong>  = " + strong.text()); 
		                		}
		                	
		                	}
		                }
		            }
	        	
	        	}
	        	else if(data.contains("Page 1 of") && data.contains("Next >>")) {
	        		System.out.println(">>>>>>>>>>>>>>>       <Table> = " + data); 
	        	}
	        	
        	}
        }
        return districts;
	}
		 

}
