import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class Home_Page {

    private static final String home_page_url ="http://automationpractice.com";
    private String blouse = "Blouse";

    @FindBy(id = "search_query_top")
    private WebElement search_field_1;

    Home_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    Home_Page open_Home_Page() throws Exception {
        open(home_page_url);
        return this;
    }

    void search_blouse() throws Exception {
        $(search_field_1).waitUntil(enabled,10000).setValue(blouse).pressEnter();
    }
}
