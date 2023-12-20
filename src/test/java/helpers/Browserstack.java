package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {

    // curl -u "aleksandra_wm3cDN:Je2rTHxYnak3kDiqxjka" -X GET "https://api.browserstack.com/app-automate/sessions/b386706a70158789aa32192d709847ab6fc2a1bb.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("aleksandra_wm3cDN", "Je2rTHxYnak3kDiqxjka")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}