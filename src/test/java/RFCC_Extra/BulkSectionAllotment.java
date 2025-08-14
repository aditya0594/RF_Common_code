package RFCC_Extra;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BulkSectionAllotment {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://uaterp.daiict.ac.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void Test1() throws InterruptedException {
		WebElement user = driver.findElement(By.id("txt_username"));
		user.sendKeys("admin");

		WebElement pass = driver.findElement(By.id("txt_password"));
		pass.sendKeys("msguat@daiict");
		Thread.sleep(6000);

		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		System.out.println("Login Successfull"); 
	}

	@Test
	public void Test2() throws Exception {
		driver.get(
				"https://uaterp.daiict.ac.in/academic/iitmsUOec6gPYh2nqs2yMmiTFCJslgIf5sZ0uXKgSseLJaunOXrXqrdPH8BzfhgXQeL48MhA7cjHJTyHISUEFEJfqng==?enc=J/hOimnKXjYzzJYY1c51QoYghZcaNRnawr87Te5lJPI=");
		Thread.sleep(1000);

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlInsName-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("DAIICT - Gandhinagar");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("select school/institute for bulk-section allotment");
		Thread.sleep(1000);

		/*
		 * driver.findElement(By.id(
		 * "select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")).click();
		 * driver.findElement(By.className("select2-search__field")).sendKeys("2023");
		 * driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER
		 * ); System.out.println("select adm batch for bulk-section allotment");
		 * Thread.sleep(1000);
		 */

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Bachelor of Technology");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("select degree for bulk-section allotment");
		Thread.sleep(1000); 

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Electronics and VLSI Design");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("select branch for bulk-section allotment");
		Thread.sleep(1000);

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("I");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("select semester for bulk-section allotment");
		Thread.sleep(1000);

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("A");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("select semester for bulk-section allotment");
		Thread.sleep(1000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnFilter")).click();
		System.out.println("Click on filter button");
		Thread.sleep(1000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEnrollFrom")).sendKeys("1");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEnrollTo")).sendKeys("10");
		Thread.sleep(1000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnConfirm")).click();
		System.out.println("Student selected for bulk section allotment");
		Thread.sleep(2000);

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlClassSection-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("A");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("select section for bulk-section allotment");
		Thread.sleep(1000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		System.out.println("Record submit successfully");

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\Users\\USER\\Desktop\\pratiksha\\Automation\\Eclipse_Screenshot_Folder"));
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
