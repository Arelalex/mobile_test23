package tests;

import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();

    String searchValueOne = "Appium";
    String searchValueTwo = "Selenide";
    String errorText = "An error occurred";
    String errorButtonText = "GO BACK";

    @Test
    void successfulSearchAppiumTest() {

        step("Type search", () -> {
            searchPage.clickSearchLine()
                    .enterValueInSearchLine(searchValueOne);

        });

        step("Verify content found", () -> {
            searchPage.checkResultNotNull();
        });
    }

    @Test
    void successfulSearchSelenideTest() {

        step("Ввести Selenide в строку поиска", () -> {
            searchPage.clickSearchLine()
                    .enterValueInSearchLine(searchValueTwo);
        });

        step("Проверить найденный контент", () -> {
            searchPage.checkResultNotNull();
        });

        step("Кликнуть по названию статьи", () -> {
            searchPage.enterValueAndClick(searchValueTwo);
        });

        step("Открыть статью и проверить, что отображается сообщение об ошибке", () -> {
            articlePage.checkErrorText(errorText);
            articlePage.checkErrorButton(errorButtonText);
        });
    }
}
