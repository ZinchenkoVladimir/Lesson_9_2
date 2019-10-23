import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class Test_Account_Creation {

    private static WebDriver driver;
    private Home_Page home_page;
    private Sign_in_Page sign_in_page;
    private Create_an_account_Page create_an_account_page;

    public Test_Account_Creation(){
    }

    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(
//                chromeOptions
        );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.supportsJavascript();
        WebDriverRunner.supportsModalDialogs();

        home_page = new Home_Page(driver);
        sign_in_page = new Sign_in_Page(driver);
        create_an_account_page = new Create_an_account_Page(driver);
    }

    @Test
    public void create_an_account() throws Exception {

        home_page
                .open_Home_Page()
                .search_blouse();

        sign_in_page
                .email_address_set()
                .create_an_account_button_click();

        create_an_account_page
                .fill_account_form()
                .register_button_click()
                .verify_validation_message();
    }

    @After
    public void tearDown() throws Exception {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        driver.quit();
    }
}
