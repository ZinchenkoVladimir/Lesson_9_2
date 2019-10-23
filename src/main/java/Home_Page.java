import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class Home_Page {

    private static final String home_page_url ="http://automationpractice.com";

    @FindBy(how = How.CLASS_NAME, using = "login")
    private WebElement sign_in_1;

    Home_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    Home_Page open_Home_Page() throws Exception {
        open(home_page_url);
        return this;
    }

    void sign_in_click() throws Exception {
        $(sign_in_1).waitUntil(enabled,10000).click();
    }
}
