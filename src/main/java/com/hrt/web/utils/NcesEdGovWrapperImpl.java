package com.hrt.web.utils;

import java.util.Map;

import org.apache.http.HttpResponse;

import com.google.common.collect.Maps;

public class NcesEdGovWrapperImpl implements NcesEdGovWrapper {

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
		return null;
	}

	public String searchForSchools(String districtName) {
		// TODO Auto-generated method stub
		return null;
	}

}
