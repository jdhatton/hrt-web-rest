package runners;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import jersey.repackaged.com.google.common.collect.Lists;

import com.hrt.data.db.beans.ZipCode;

public class ZipCodeLoaderRunner {

	public ZipCodeLoaderRunner() {
		// TODO Auto-generated constructor stub
	}

	public List<ZipCode> run() {

		System.out.println("\n STARTING LOAD \n ");
		String csvFile = "/Users/jdhatton/Documents/devenv/projects/hrt-web-rest/hrt-web-rest/free-zipcode-database-Primary.csv"; 
		//"/home/jdhatton/devenv/workspace01/web-rest-dp/free-zipcode-database-Primary.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ZipCode zipCode = new ZipCode();
		List<ZipCode> zipCodes = Lists.newArrayList();
		long counter =0L;
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
 
				if(counter == 1){
					//skip first line
				} else {
					// use comma as separator
					String[] data = line.split(cvsSplitBy);
//					System.out.println(" data length   = " + data.length);
//					System.out.println(" data[0]  = " + data[0]);
//					System.out.println(" data[1]  = " + data[1]);
//					System.out.println(" data[2]  = " + data[2]);
//					System.out.println(" data[3]  = " + data[3]);
 
					//   1            2        3    4        5           6    7      8          9              10                11
					// zipCode, ZipCodeType, City, State, LocationType, Lat, Long, Location, Decommisioned, TaxReturnsFiled, EstimatedPopulation, TotalWages 
					
					zipCode = null;
					zipCode = new ZipCode(data[0], data[1], data[2],data[3] );
					if(data.length > 8 ){
						zipCode.setLat(data[5]);
						zipCode.setLon(data[6]);
						zipCode.setLocation(data[7]);
					}
					if(data.length > 10 ){
						zipCode.setEstimatedPopulation(data[10]);
					}
					
//					System.out.println(" ZIPCODE  = " + zipCode.toString());
					zipCodes.add(zipCode);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Done");
		return zipCodes;
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ZipCodeLoaderRunner obj = new ZipCodeLoaderRunner();
		obj.run();

	}

}
