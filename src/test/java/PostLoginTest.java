import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PostLoginTest{
    public static WebDriver driver;

    @Test
    void test() throws IOException, InterruptedException {

        //Creating object and path for reading property file
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("D:\\Intellij idea\\src\\main\\resources\\General.properties");
        properties.load(input);


        //Checking the browsers from the property file
        if (properties.getProperty("browser").equalsIgnoreCase(Constants.CHROME)) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (properties.getProperty("browser").equalsIgnoreCase(Constants.FIREFOX)) {

            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();

        } else if (properties.getProperty("browser").equalsIgnoreCase(Constants.Edge)) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        /* Prints Date as per the mentioned format */
        System.out.println(Utils.formattedDate());

        /* Disables chrome functions */
        Utils.disableChromefunctions();


        /* Opens the website */
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Website loaded successfully");

        //
        driver.findElement(By.xpath("//div[@class= 'header_logIn___ctid block']")).click();
        driver.findElement(By.id("email")).sendKeys(properties.getProperty("email"));
        driver.findElement(By.name("pwd")).sendKeys(properties.getProperty("password"));
        driver.findElement(By.xpath("//div[text()= 'Login']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("dobOrpan")).sendKeys(properties.getProperty("dob"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //JavascriptExecutor js  = (JavascriptExecutor)driver;
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Authenticate')]")).click();
        System.out.println("Log-in Successful");

        driver.findElement(By.xpath("//div[@class= 'close-icon ng-star-inserted']")).click();
    }
}
