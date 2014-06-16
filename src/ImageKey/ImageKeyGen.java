package ImageKey;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import com.proquest.services.ems.ExternalMediaHelper;

public class ImageKeyGen {

	public static final String path = "/media/csa/objects-set-c/nature/00205/35958fcf-b70c-4b74-b701mfgefd107/obj/gt201383a_Figure_2_Page_3.tiff/wm.jpg";
	public static final String path2 = "/media/pq/classic/doc/1996631791/fmt/zi/rep/full/zone/2";
	
	
	public static void main(String[] args) {
		System.out.println("Going to generate an image key");
		String emsPath = "";
		try {
			emsPath = ExternalMediaHelper.cookMediaIndex(path2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("EMS Path is: "+emsPath);
	}

}
