package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticlePage {
    SelenideElement
            errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text")),
            errorButton = $(id("org.wikipedia.alpha:id/view_wiki_error_button"));

    public ArticlePage checkErrorText(String value) {
        errorText.shouldHave(text(value));

        return this;
    }

    public ArticlePage checkErrorButton(String value) {
        errorButton.shouldHave(text(value));

        return this;
    }
}
