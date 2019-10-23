import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

class Search_Blouse_Page {

    @FindBy(className = "icon-th-list")
    private WebElement list;

    @FindBy(css = "a[class = 'button ajax_add_to_cart_button btn btn-default']")
    private WebElement add_to_cart_button;

    @FindBy(css = "a[class = 'btn btn-default button button-medium']")
    private WebElement proceed_to_checkout_button;

    Search_Blouse_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    Search_Blouse_Page list_switch() throws Exception {
        $(list).waitUntil(enabled,10000).click();
        return this;
    }

    Search_Blouse_Page add_to_cart_button_click() throws Exception {
        $(add_to_cart_button).waitUntil(enabled,10000).click();
        return this;
    }

    void proceed_to_checkout_button_click() throws Exception {
        $(proceed_to_checkout_button).waitUntil(enabled,10000).click();
    }
}
