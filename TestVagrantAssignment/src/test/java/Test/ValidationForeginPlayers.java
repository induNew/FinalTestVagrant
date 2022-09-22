package Test;

import java.util.List;

import org.testng.Assert;

import API_Configuration.APIPath;
import API_Configuration.BodyConfigs;
import API_Configuration.HeaderConfigs;
import API_Configuration.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidationForeginPlayers {

	public static void main(String[] args) {
		
		APIPath AP = new APIPath();
		HeaderConfigs headervalue = new HeaderConfigs();
		BodyConfigs bodyvalue = new BodyConfigs();
		JsonUtils JS = new JsonUtils();
		
		RestAssured.baseURI = AP.RCB_PLAYER_LIST;
		
		Response response = RestAssured.given().headers(headervalue.defaultLoginAPI()).when()
				.body(bodyvalue.RCBBody()).post(AP.RCB_PLAYER_LIST);

		String responsevalue = response.asString();

		response.then().assertThat().statusCode(200);
		int count=0;
		List<String> PlayersList=JS.getListOfStringFromJsonPath(responsevalue, "player[*].country[*]");
		for(int i=0;i<= PlayersList.size()-1;i++) {
			
			Assert.assertNotEquals(PlayersList.get(i),"India");
			++count;
		}
		if(count>=4) {
			System.out.println("Team has"+count+"Foreign Players");
		}else {
			System.out.println("Team has less than 4 foregin players");
		}

	}
}
