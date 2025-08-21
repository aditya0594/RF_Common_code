package StudentAdmissionTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");

            // Set zoom to 60%
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='60%'");
        }

}
