package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.name;
import static io.qameta.allure.Allure.step;

public class IosTests extends TestBase {
    @Test
    @Tag("ios")
    void visibleMainPageTest() {
        step("Check main page", () -> {
            $(name("Sample iOS")).shouldBe(visible);
            $(name("UI Elements")).shouldBe(visible);
            $(name("Alert Button")).shouldBe(visible);
            $(name("Alert")).shouldBe(visible);
            $(name("Text")).shouldBe(visible);
            $(name("Tab Bar")).should(visible);
            $(name("Web View")).should(visible);
            $(name("nav_ui")).should(visible);
            $(name("Local Testing")).should(visible);
        });
    }
}
