import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class Test_Blouse_Shopping {

    private static WebDriver driver;
    private Home_Page home_page;
    private Search_Blouse_Page search_blouse_page;
    private Cart_Summary_Page cart_summary_page;

    public Test_Blouse_Shopping(){
    }

    @BeforeClass
    public static void setDriver(){
        ChromeDriverManager.getInstance().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.operadriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.iedriver().setup();
    }

    @Before
    public void setUp() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new OperaDriver(
//                chromeOptions
        );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.supportsJavascript();
        WebDriverRunner.supportsModalDialogs();

        home_page = new Home_Page(driver);
        search_blouse_page = new Search_Blouse_Page(driver);
        cart_summary_page = new Cart_Summary_Page(driver);
    }

    @Test
    public void create_an_account() throws Exception {

        home_page
                .open_Home_Page()
                .search_blouse();

        search_blouse_page
                .list_switch()
                .add_to_cart_button_click()
                .proceed_to_checkout_button_click();

        cart_summary_page
                .plus_button_click()
                .verify_totals()
                .delete_button_click()
                .verify_empty_cart();
    }

    @After
    public void tearDown() throws Exception {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        driver.quit();
    }
}
