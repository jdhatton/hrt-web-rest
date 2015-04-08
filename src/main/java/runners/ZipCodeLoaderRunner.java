package runners;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZipCodeLoaderRunner {

	public ZipCodeLoaderRunner() {
		// TODO Auto-generated constructor stub
	}

	public void run() {

		String csvFile = "/home/jdhatton/devenv/workspace01/web-rest-dp/free-zipcode-database-Primary.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ZipCode zipCode = new ZipCode();
		try {

			Map<String, String> maps = new HashMap<String, String>();

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				
				// zipCode, ZipCodeType, City, State, LocationType, Lat, Long, Location, Decommisioned, TaxReturnsFiled, EstimatedPopulation, TotalWages 
				
				zipCode = null;
				zipCode = new ZipCode(data[1], data[2], data[3],data[4], data[6], data[7], data[8], data[9], data[11]);
//				maps.put(data[4], data[5]);
				
				System.out.println(" ZIPCODE  = " + zipCode.toString());

			}

			// loop map
//			for (Map.Entry<String, String> entry : maps.entrySet()) {
//
//				System.out.println("Country [code= " + entry.getKey()
//						+ " , name=" + entry.getValue() + "]");
//
//			}

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
