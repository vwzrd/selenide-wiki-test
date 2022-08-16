package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPricingTest {

    @Test
    void comparePlansShouldLeadToPricingPage () {
        open("https://github.com/");
        $("html").hover();
        $(".HeaderMenu").$(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        $(".font-mktg").shouldHave(text("Choose the plan that’s right for you."));
    }
}
