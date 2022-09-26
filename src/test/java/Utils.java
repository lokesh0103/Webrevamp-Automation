import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utils {

    public static WebDriver driver;
    public static String formattedDate() {

        /** Returns time in day-mm-dd-hr-min-sec-Ist-2022 */

        Date currentDate = new Date();
        return currentDate.toString().replace(" ", "-").replace(":", "-");
    }

    public static void disableChromeFunctions() {

        //Disabling chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("--disable-save-password");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
    }

    public static String screenshot() throws IOException {

        //Taking screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".\\screenshot\sscreenshot.png"));
        System.out.println("Screenshot taken");
        return null;

    }
}
