import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PostLoginTest {
    public static WebDriver driver;

    public static void logIn() throws IOException, InterruptedException {

        //Creating object and path for reading property file
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("D:\\Webrevamp\\src\\main\\resources\\General.properties");
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
        Utils.disableChromeFunctions();


        /* Opens the website */
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Website loaded successfully");


        driver.findElement(By.xpath("//div[@class= 'header_logIn___ctid block']")).click();
        driver.findElement(By.id("email")).sendKeys(properties.getProperty(Constants.EMAIL));
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

    public static void Sip() throws IOException, InterruptedException {

        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("D:\\Webrevamp\\src\\main\\resources\\General.properties");
        properties.load(input);


        /* CLicking Invest Button */
        driver.findElement(By.xpath("//body/app-root[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/app-fi-dashboard[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[2]/section[1]/button[1]")).click();

        /* Clicking Sip */
        driver.findElement(By.xpath("//body/app-root[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/app-mf-dashboard[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();

        /* Applying Filter */
        driver.findElement(By.id("name-1")).click();

        /* clicking Search */
        driver.findElement(By.name("queryString")).sendKeys(properties.getProperty(Constants.SEARCH));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//body/app-root[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/app-scheme-listing[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[11]/div[1]/img[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Proceed to basket')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Okay')]")).click();
        driver.findElement(By.xpath("//body/app-root[1]/app-investment-basket[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/app-number-operator[1]/div[1]/img[2]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


















    }
}