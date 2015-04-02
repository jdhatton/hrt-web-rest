package com.hrt.web.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jersey.repackaged.com.google.common.collect.Lists;
import jersey.repackaged.com.google.common.collect.Sets;

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
import com.hrt.data.db.dao.DistrictDaoImpl;
import com.hrt.web.services.DistrictService;
import com.hrt.web.services.DistrictServiceImpl;

public class NcesEdGovWrapperImpl implements NcesEdGovWrapper {

	private final String USER_AGENT = "Mozilla/5.0";
	
	public NcesEdGovWrapperImpl() {
		// TODO Auto-generated constructor stub
	}

	public String searchForDistricts(String zipCode) {
		
		
		System.out.println(" \n\n   zipCode =  " + zipCode);
 
		String webPage = execHttpRequest(zipCode);
		
		
		Set<District> districts = parseHtml(webPage);
		System.out.println("\n >>>>  size of districts = " + districts.size());
		
		DistrictService service = new DistrictServiceImpl(new DistrictDaoImpl());
		for(District district : districts){
			try{
				service.addDistrict(district);
			} catch(Exception ex){ex.printStackTrace();}
		}
		
		return webPage;
	}

	public String searchForSchools(String districtName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param zipCode
	 * @return
	 */
	private String execHttpRequest(String zipCode){
	
		
		String url = "http://nces.ed.gov/ccd/districtsearch/district_list.asp";  // "https://selfsolve.apple.com/wcResults.do";
		HttpResponse response = null;
		StringBuffer result = new StringBuffer();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
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
 
			BufferedReader rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
 		
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}	
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
	protected Set<District> parseHtml(String html) {
		
		Document doc = null;
		Set<District> districts = Sets.newHashSet();
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
        	String tabHtml = table.html();
        	 
        	if( data.length() > 0){
	        	if( Character.isDigit(data.charAt(0))){
		        	for (Element row : table.select("tr")) {
		        		System.out.println(">>>   ");
		                Elements tds = row.select("td");
		                if(tds != null && tds.size() > 0){
		                	int counter =0;
		                	District district = new District();
		                	for(Element td : tds){
		                		counter++;
		                		System.out.println(">>>    counter    = " + counter ); 
		                		//System.out.println(">>>    <TD>  = " + td.html() ); 
		                		
		                		Document districtTD =Jsoup.parse(td.html());		                		
		                		for (Element href : districtTD.select("a")) {
		                        	String link = "http://nces.ed.gov/ccd/districtsearch/"+href.attr("href");
		                        	System.out.println(">>>    <a>  = " + link); 
		                        	district.setHtmlLink(link);
		                		}	
		                		for (Element font : districtTD.select("font")) {
		                        	//String dfont = font.text();
		                        	System.out.println(">>>    <font>  = " + font.text()); 
		                        	if(counter == 1){
		                        		// distance
		                        		district.setDistance(font.text());
		                        	} else if( counter == 2){
		                        		// address
		                        		district.setAddress(font.text());
		                        	} else if( counter == 3){
		                        		// phone
		                        		district.setPhone(font.text());
		                        	} else if( counter == 4){
		                        		// county
		                        		district.setCounty(font.text());
		                        	} else if( counter == 5){
		                        		// numStudents
		                        		district.setNumStudents(font.text());
		                        	} else if( counter == 6){
		                        		// numSchools
		                        		district.setNumSchools(font.text());
		                        	}
		                		}
		                		for (Element strong : districtTD.select("strong")) {
		                        	 
		                        	System.out.println(">>>    <strong>  = " + strong.text()); 
		                        	district.setName(strong.text());
		                		}
		                	districts.add(district);
		                	}
		                }
		            }
	        	
	        	}
	        	else if(data.contains("Next >>")) {
	        		if(data.length() < 60) { // hard code to avoid all the other crap.
		        		System.out.println("\n\n >>>>>>>>>>>>>>> >>>>>>>>  >>>>>>>    >>>>>>         <Table> = " + data); 
		        		// Page 1 of 2    1 - 15   Next >>
		        		
		        		//
		        		// TODO: parse the string to determine the number of pages.
		        		//
		        		  
		        		 String[] splits = data.split(" ");
	
		        		 System.out.println("splits.size: " + splits.length);
	
		        		 if(splits != null && splits.length > 0){
		        			 for(String asset: splits){
			        			 if(asset.contains("of")){
			        				 //
			        				 // This is the 1 of X where X is the # pages in the pagination.
			        				 //
			        				 String lastPage = asset.substring(asset.length()-2, asset.length());
			        				 System.out.println(" lastPage  =  [" + lastPage+"]");
			        				 int lastPageNum = Integer.valueOf(lastPage.trim());
			        				 System.out.println(" lastPageNum  =  [" + lastPageNum+"]");
			        			 }
			        		 }
		        		 }
		        		 
		        		 
	 
		        		
		        		 // &DistrictPageNum=1
		        		 System.out.println(" ");
	        		}
	        	}
	        	
        	}
        }
        System.out.println("\n\n RETURNING :   " + districts.toString());
        return districts;
	}
		 

}
