package com.hrt.web.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import com.hrt.data.db.beans.District;
import com.hrt.data.db.dao.DistrictDaoImpl;
import com.hrt.data.db.dao.ZipCodeDaoImpl;
import com.hrt.web.services.DistrictService;
import com.hrt.web.services.DistrictServiceImpl;
import com.hrt.web.services.ZipCodeService;
import com.hrt.web.services.ZipCodeServiceImpl;

public class NcesEdGovWrapperImpl implements NcesEdGovWrapper {

	private final String USER_AGENT = "Mozilla/5.0";
	
	public NcesEdGovWrapperImpl() {
	}
	
	
	/**
	 * 
	 */
	public String searchForDistricts( ) throws Exception {
		
		
		DistrictService service = new DistrictServiceImpl(new DistrictDaoImpl());
		ZipCodeService zipService = new ZipCodeServiceImpl(new ZipCodeDaoImpl());
		//
		// Read in all the zipcode from the zipcode table and process them one by one.
		//
		Set<String> zipCodes = zipService.getAllZips();
		
		
		for(String zipCode : zipCodes ){
			if(zipCode.trim().length() > 4){		
				int pageNumber = 1;		 
				String strPageNumber = Integer.toString(pageNumber);
				
				String webPage = execHttpRequest(zipCode, strPageNumber);
				int numPages = parseForNumberOfPages(webPage);
				
				System.out.println("Processing ["+numPages+"] Pages ...");
				for (int i = 1; i < numPages+1; i++) {
					TimeUnit.SECONDS.sleep(3);
					strPageNumber = Integer.toString(i);			
					System.out.println("\n\n   zipCode =  " + zipCode);
					System.out.println("   pageNumber =  " + strPageNumber);
					
					String webPageData = execHttpRequest(zipCode, strPageNumber);
					
					Set<District> districts = parseHtml(webPageData);
					System.out.println("\n >>>>  size of districts = " + districts.size());
					
					
					for(District district : districts){
						try{
							district.setZip(zipCode);
							service.addDistrict(district);
						} catch(Exception ex){ex.printStackTrace();}
					}
				}
				
				//
				// Very important we delay after each one...
				//
				if(numPages > 0) {
					System.out.println("Starting the sleep for 5 seconds.... BE RIGHT BACK!   >>>     " + zipCode);
					TimeUnit.SECONDS.sleep(5);
					System.out.println("15 seconds is up and ....we are back... ");
				}
				
			}
			else {
				System.out.println(" SKIPPING zipCode :  "+ zipCode);
			}
		}
		
		return "";
	}
	
	
	/**
	 * 
	 */
	public String searchForDistricts(String zipCode) throws Exception {
		
		int pageNumber = 1;		 
		String strPageNumber = Integer.toString(pageNumber);
		
		String webPage = execHttpRequest(zipCode, strPageNumber);
		int numPages = parseForNumberOfPages(webPage);
		
		
		for (int i = 1; i < numPages+1; i++) {
			strPageNumber = Integer.toString(i);			
			System.out.println("\n\n   zipCode =  " + zipCode);
			System.out.println("   pageNumber =  " + strPageNumber);
			
			String webPageData = execHttpRequest(zipCode, strPageNumber);
			
			Set<District> districts = parseHtml(webPageData);
			System.out.println("\n >>>>  size of districts = " + districts.size());
			
			DistrictService service = new DistrictServiceImpl(new DistrictDaoImpl());
			for(District district : districts){
				try{
					district.setZip(zipCode);
					service.addDistrict(district);
				} catch(Exception ex){ex.printStackTrace();}
			}
		}
		return "";
	}

	public String searchForSchools(String districtName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param zipCode
	 * @return
	 */
	private String execHttpRequest(String zipCode, String pageNumber){
	
		
		String url = "http://nces.ed.gov/ccd/districtsearch/district_list.asp";   
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
		urlParameters.add(new BasicNameValuePair("DistrictPageNum", pageNumber));
			 
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
 
			response = client.execute(post);
			System.out.println("Response Code : "  + response.getStatusLine().getStatusCode());
 
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
		
//		return "";
		
	}
	
	/**
	 * 
	 * @param html
	 * @return
	 * @throws Exception
	 */
	protected int parseForNumberOfPages(String html) throws Exception {
		
		int numPages =0;
		
		Document doc = null;
				 
		doc =Jsoup.parse(html);
 
		for (Element table1 : doc.select("table")) {
        	String data1 = table1.text();    
        	if( data1.length() > 0){
	        	 if(data1.contains("Next >>")) {
	        		if(data1.length() < 60) { // hard code to avoid all the other crap.
		        		System.out.println("\n\n PAGES = " + data1); 
		        		// Page 1 of 2    1 - 15   Next >>
		        		 String[] splits = data1.split(" ");	
		        		 if(splits != null && splits.length > 0){
		        			 for(String asset: splits){
			        			 if(asset.contains("of")){
			        				 //
			        				 // This is the 1 of X where X is the # pages in the pagination.
			        				 //
			        				 String lastPage = asset.substring(asset.length()-2, asset.length());
			        				 System.out.println(" lastPage  =  [" + lastPage+"]");
			        				 String lastPage2= lastPage.replaceAll("[^0-9]", "");
			        				 System.out.println(" lastPage2  =  [" + lastPage2+"]");
			        				 int lastPageNum = Integer.valueOf(lastPage2);
			        				 System.out.println(" lastPageNum  =  [" + lastPageNum+"]");
			        				 numPages = lastPageNum;
			        			 }
			        		 }
		        		 }
	        		}
	        	} 	
        	}
		}
		return numPages;
	}
	
	
	/**
	 * Method to parse out the relevant info for Districts.
	 * 
	 * @param html
	 */
	protected Set<District> parseHtml(String html) throws Exception {

		Set<District> districts = Sets.newHashSet();
		Document doc = Jsoup.parse(html);

		for (Element table : doc.select("table")) {
			String data = table.text();

			if (data.length() > 0) {
				if (Character.isDigit(data.charAt(0))) {
					for (Element row : table.select("tr")) {
						System.out.println(">>>   ");
						Elements tds = row.select("td");
						if (tds != null && tds.size() > 0) {
							int counter = 0;
							District district = new District();
							for (Element td : tds) {
								counter++;
								System.out.println(">>>    counter    = " + counter);
								// System.out.println(">>>    <TD>  = " +
								// td.html() );

								Document districtTD = Jsoup.parse(td.html());
								for (Element href : districtTD.select("a")) {
									String link = "http://nces.ed.gov/ccd/districtsearch/" + href.attr("href");
									System.out.println(">>>    <a>  = " + link);
									district.setHtmlLink(link);
								}
								for (Element font : districtTD.select("font")) {
									// String dfont = font.text();
									System.out.println(">>>    <font>  = " + font.text());
									if (counter == 1) {
										// distance
										district.setDistance(font.text());
									} else if (counter == 2) {
										// address
										district.setAddress(font.text());
									} else if (counter == 3) {
										// phone
										district.setPhone(font.text());
									} else if (counter == 4) {
										// county
										district.setCounty(font.text());
									} else if (counter == 5) {
										// numStudents
										district.setNumStudents(font.text());
									} else if (counter == 6) {
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
			}

		}
		return districts;
	}
		 

}
