package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiTest {

    @Test
    void selenideWikiSoftAssertsTest () {

        //открываем GitHub
        open("https://github.com/");
        //ищем Selenide
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажимаем на первый результат
        $$("ul.repo-list li").first().$("a").click();
        //проверяем, что попали в правильный репозиторий
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        //переходим в wiki
        $("#wiki-tab").click();
        //раскрываем полный список страниц
        $("button.js-wiki-more-pages-link").click();
        //проверяем, что в списке есть SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        //открываем страницу SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        //проверяем, что в тексте есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
