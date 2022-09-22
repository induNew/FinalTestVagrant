package API_Configuration;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

	static String CONTENT_TYPE_KEY = "";
	static String CONTENT_TYPE_VALUE = "";

	public Map<String, Object> defaultLoginAPI() {
		Map<String, Object> headerwithouttoken = new HashMap<String, Object>();
		headerwithouttoken.put(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
		headerwithouttoken.put("x-access-token", "OKfwVWAUlTXia65gHHYrWkPWGN1imnwcN7cRdT7VGlllwPJCkz7YRVdWxznJ0f59");
		headerwithouttoken.put("x-secret-key", "Ptpw9dWQM9EqCLPv6aNQYBFPIWZITBd3HXRSDa4xtGBOeqEbf2TChiPlvd5E7FNE");
		headerwithouttoken.put("x-mclient-id", "wp");
		return headerwithouttoken;
	}

}