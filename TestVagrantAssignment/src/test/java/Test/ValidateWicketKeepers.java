package Test;

import java.util.List;

import API_Configuration.APIPath;
import API_Configuration.BodyConfigs;
import API_Configuration.HeaderConfigs;
import API_Configuration.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//.
public class ValidateWicketKeepers {
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
		List<String> PlayersList=JS.getListOfStringFromJsonPath(responsevalue, "player[*].role[*]");
		for(int i=0;i<= PlayersList.size()-1;i++) {
			if(PlayersList.get(i).contains("Wicket-keeper"))
			{
				System.out.println("Wicket Keeper is available in the list of players");
			}else {
				System.out.println("No Wicket Kepper is available in the players list");
			}
		}
	}
}
