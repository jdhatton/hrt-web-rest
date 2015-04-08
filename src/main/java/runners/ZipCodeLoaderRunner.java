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

		System.out.println("\n STARTING LOAD \n ");
		String csvFile = "/home/jdhatton/devenv/workspace01/web-rest-dp/free-zipcode-database-Primary.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ZipCode zipCode = new ZipCode();
		long counter =0L;
		try {

			Map<String, String> maps = new HashMap<String, String>();

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if(counter > 30){ return; }
				counter++;
				if(counter == 1){
					//skip first line
				} else {
					// use comma as separator
					String[] data = line.split(cvsSplitBy);
					System.out.println(" data length   = " + data.length);
					System.out.println(" data[0]  = " + data[0]);
					System.out.println(" data[1]  = " + data[1]);
					System.out.println(" data[2]  = " + data[2]);
					System.out.println(" data[3]  = " + data[3]);
 
					// zipCode, ZipCodeType, City, State, LocationType, Lat, Long, Location, Decommisioned, TaxReturnsFiled, EstimatedPopulation, TotalWages 
					
					zipCode = null;
					zipCode = new ZipCode(data[1], data[2], data[3],data[4] );
	//				maps.put(data[4], data[5]);
					
					System.out.println(" ZIPCODE  = " + zipCode.toString());
				}

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
