package com.hrt.web.utils;

public interface NcesEdGovWrapper {
	
	String fullURL = "http://nces.ed.gov/ccd/districtsearch/district_list.asp?Search=1&details=1&InstName=&DistrictID=&Address=&City=&State=&Zip=66220&Miles=15&County=&PhoneAreaCode=&Phone=&DistrictType=1&DistrictType=2&DistrictType=3&DistrictType=4&DistrictType=5&DistrictType=6&DistrictType=7&NumOfStudents=&NumOfStudentsRange=more&NumOfSchools=&NumOfSchoolsRange=more&DistrictPageNum=1";	
 	                	  
	public String searchForDistricts( String zipCode ) throws Exception;
	
	public String searchForSchools( String districtName ) throws Exception;
	
	
}
