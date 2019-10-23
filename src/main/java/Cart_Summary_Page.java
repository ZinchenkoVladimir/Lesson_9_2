import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

class Cart_Summary_Page {

    @FindBy(id = "cart_quantity_up_2_7_0_0")
    private WebElement plus_button;

    @FindBy(id = "total_product_price_2_7_0")
    private WebElement total_for_blouse;

    @FindBy(id = "total_product")
    private WebElement total_products;

    @FindBy(id = "total_shipping")
    private WebElement total_shipping;

    @FindBy(id = "total_price_without_tax")
    private WebElement total_price_without_tax;

    @FindBy(id = "total_tax")
    private WebElement total_tax;

    @FindBy(id = "total_price")
    private WebElement total_price;

    @FindBy(css = "a[class = cart_quantity_delete]")
    private WebElement delete_button;

    @FindBy(css = "p[class = 'alert alert-warning']")
    private WebElement warning_message;

    @FindBy(css = "span[class = 'ajax_cart_no_product']")
    private WebElement empty_cart_placeholder;

    Cart_Summary_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    Cart_Summary_Page plus_button_click() throws Exception {
        $(plus_button).waitUntil(enabled,10000).click();
        return this;
    }

    Cart_Summary_Page verify_totals() throws Exception {
        $(total_for_blouse).waitUntil(enabled,10000).shouldHave(exactText("$54.00"));
        $(total_products).waitUntil(enabled,10000).shouldHave(exactText("$54.00"));
        $(total_shipping).waitUntil(enabled,10000).shouldHave(exactText("$2.00"));
        $(total_price_without_tax).waitUntil(enabled,10000).shouldHave(exactText("$56.00"));
        $(total_tax).waitUntil(enabled,10000).shouldHave(exactText("$0.00"));
        $(total_price).waitUntil(enabled,10000).shouldHave(exactText("$56.00"));
        return this;
    }

    Cart_Summary_Page delete_button_click() throws Exception {
        $(delete_button).waitUntil(enabled,10000).click();
        return this;
    }

    void verify_empty_cart() throws Exception {
        $(warning_message).waitUntil(enabled,10000).shouldHave(exactText("Your shopping cart is empty."));
        $(empty_cart_placeholder).waitUntil(enabled,10000).shouldHave(exactText("(empty)"));

    }
}
