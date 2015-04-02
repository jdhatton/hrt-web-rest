package com.hrt.web.utils;

public interface NcesEdGovWrapper {
	
	String fullURL = "http://nces.ed.gov/ccd/districtsearch/district_list.asp?Search=1&details=1&InstName=&DistrictID=&Address=&City=&State=&Zip=66220&Miles=15&County=&PhoneAreaCode=&Phone=&DistrictType=1&DistrictType=2&DistrictType=3&DistrictType=4&DistrictType=5&DistrictType=6&DistrictType=7&NumOfStudents=&NumOfStudentsRange=more&NumOfSchools=&NumOfSchoolsRange=more";	
//	                  http://nces.ed.gov/ccd/districtsearch/district_list.asp?Search=1&details=1&Zip=66220&Miles=15&DistrictType=1&DistrictType=2&DistrictType=3&DistrictType=4&DistrictType=5&DistrictType=6&DistrictType=7&NumOfStudentsRange=more&NumOfSchoolsRange=more&DistrictPageNum=2
	
//	<TD width='67%' align='right'>
//	  <font color='#FFFFFF' size='2'>
//	    <strong>
//	      <font color='#EDFFE8'>&nbsp;&nbsp;&nbsp;1 - 15&nbsp;&nbsp;&nbsp;</FONT>
//	      <a class='ignoredclass1' href="district_list.asp?Search=1&details=1&Zip=66220&Miles=15&DistrictType=1&DistrictType=2&DistrictType=3&DistrictType=4&DistrictType=5&DistrictType=6&DistrictType=7&NumOfStudentsRange=more&NumOfSchoolsRange=more&DistrictPageNum=2">Next &gt;&gt;</a>&nbsp;&nbsp;
//	      </TR></TABLE>
      	  
	                	  
	                	  
	public String searchForDistricts( String zipCode );
	
	public String searchForSchools( String districtName );
	
	
}
