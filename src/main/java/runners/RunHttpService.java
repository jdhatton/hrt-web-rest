/**
 * 
 */
package runners;

import com.hrt.web.utils.NcesEdGovWrapper;
import com.hrt.web.utils.NcesEdGovWrapperImpl;

/**
 * @author jdhatton
 *
 */
public class RunHttpService {

	/**
	 * 
	 */
	public RunHttpService() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		System.out.println(" START ");
		
		NcesEdGovWrapper wrapper = new NcesEdGovWrapperImpl();
		String resp = wrapper.searchForDistricts("66220");
		//System.out.println(" resp =  " + resp);
		System.out.println(" FINISH ");

	}

}
