package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    private final static String SEARCH_VALUE_ONE = "Appium";
    private final static String SEARCH_VALUE_TWO = "Selenide";
    private final static String ERROR_TEXT = "An error occurred";
    private final static String ERROR_BUTTON_TEXT = "GO BACK";
    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();

    @Test
    @Tag("android")
    void successfulSearchAppiumTest() {

        step("Type search", () -> {
            searchPage.clickSearchLine()
                    .enterValueInSearchLine(SEARCH_VALUE_ONE);

        });

        step("Verify content found", () -> {
            searchPage.checkResultNotNull();
        });
    }

    @Test
    @Tag("android")
    void successfulSearchSelenideTest() {

        step("Ввести Selenide в строку поиска", () -> {
            searchPage.clickSearchLine()
                    .enterValueInSearchLine(SEARCH_VALUE_TWO);
        });

        step("Проверить найденный контент", () -> {
            searchPage.checkResultNotNull();
        });

        step("Кликнуть по названию статьи", () -> {
            searchPage.enterValueAndClick(SEARCH_VALUE_TWO);
        });

        step("Открыть статью и проверить, что отображается сообщение об ошибке", () -> {
            articlePage.checkErrorText(ERROR_TEXT);
            articlePage.checkErrorButton(ERROR_BUTTON_TEXT);
        });
    }
}
