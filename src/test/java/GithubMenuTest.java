import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GithubMenuTest {
    @BeforeAll
    static void settingsBeforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void openSolutionsEnterprisePage() {
        open("");
        $$("nav li").findBy(text("Solutions"))
                .hover()
                .$(byTagAndText("a", "Enterprise")).click();
        $("head title").shouldHave(
                attribute("text", "The AI Powered Developer Platform. · GitHub")
        );
    }
}
