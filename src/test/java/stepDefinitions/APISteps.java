package stepDefinitions;
import factory.GetRequestEX;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import utils.ConfigReader;
import java.io.IOException;


public class APISteps {
    ConfigReader _configReader = new ConfigReader();
    private JSONArray jsonResults = null;


    @Given("User makes a get request to typicode.com")
    public void userMakesAGetRequestToTypicodeCom() throws IOException, InterruptedException {
        String configString = _configReader.getValueFromConfig("typicodeUrl");
        jsonResults = new JSONArray(GetRequestEX.getRequest(configString));
    }

    @Then("User verifies {string} exist")
    public void userVerifiesExist(String arg0) {
        for(int n = 0; n < jsonResults.length(); n++)
        {
            JSONObject personObject = jsonResults.getJSONObject(n);
            String name = (String) personObject.get("name");
            if(name.contains(arg0)){
                Assert.assertTrue(name.contains(arg0));
            }
        }
    }

    @Then("User verifies address exist for {string}")
    public void userVerifiesAddressExistFor(String arg0) {
       try{
           String fileContent = _configReader.readFile("src/test/Config/data.json");
           JSONObject json = new JSONObject(fileContent);
           JSONObject jsonAddress = (JSONObject) json.get("address");
           for(int n = 0; n < jsonResults.length(); n++)
           {
               JSONObject personObject = jsonResults.getJSONObject(n);
               String name = (String) personObject.get("name");
               if(name.contains(arg0)){
                   JSONObject address = (JSONObject) personObject.get("address");
                   String _address = address.toString();
                   Assert.assertTrue(_address.contains(jsonAddress.toString()));
               }
           }
       }catch (Exception e){
           e.getStackTrace();
       }
    }
}


