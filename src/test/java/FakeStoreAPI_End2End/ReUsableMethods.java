package FakeStoreAPI_End2End;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
    public static JsonPath rawToJson(String response){
        JsonPath js = new JsonPath(response);
        return js;
    }
}
