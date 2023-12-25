package helpers;

import config.UserConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class Browserstack {
    static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());

    // curl -u "aleksandra_wm3cDN:Je2rTHxYnak3kDiqxjka" -X GET "https://api.browserstack.com/app-automate/sessions/b386706a70158789aa32192d709847ab6fc2a1bb.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(userConfig.getUserName(), userConfig.getAccessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}