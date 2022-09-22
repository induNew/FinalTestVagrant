package API_Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class JsonUtils {
	
	public List<String> getListOfStringFromJsonPath(String json, String xpath) {
		List<String> outPutList = new ArrayList<String>();
		try {
			String classType = JsonPath.read(json, xpath).getClass().toString();
			if (classType.contains("java.lang.String") || classType.contains("java.lang.Integer")) {
				outPutList.add(JsonPath.read(json, xpath).toString());
			} else {
				Collection<? extends String> array = JsonPath.read(json, xpath);
				if (array.size() > 0) {
					for (Object ob : array) {
						outPutList.add(ob.toString());
					}
				}
				return outPutList;
			}
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		return outPutList;
	}
}
