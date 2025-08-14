package extraFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacultyAdvisorAllotment {
	private WebDriver driver;
	private JavascriptExecutor js;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rfcautomationuat.mastersofterp.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void Test1() throws InterruptedException {
		WebElement user = driver.findElement(By.id("txt_username"));
		user.sendKeys("admin");

		WebElement pass = driver.findElement(By.id("txt_password"));
		pass.sendKeys("test@2023");
		WebElement capcha = driver.findElement(By.id("txtcaptcha"));
		capcha.sendKeys("RFC@123");
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		System.out.println("Login Successfull");
	}

	@Test
	public void Test2() throws Exception {
		WebElement aca = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[2]/a"));
		System.out.println("Click on Academic module ");
		Actions action = new Actions(driver);
		action.moveToElement(aca).perform();
		WebElement aca_cor = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:25\"]/li[8]/a"));
		System.out.println("Click on Coordinator Related sub-module ");
		Thread.sleep(1000);
		action.moveToElement(aca_cor);
		action.click().build().perform();
		System.out.println("Course Creation page display ");
		Thread.sleep(1000);
		WebElement Scroll = driver.findElement(By.id("ctl00_repLinks_ctl28_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Scroll);
		driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl20_lbLink\"]")).click();
		System.out.println("Faculty Advisor page display ");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollegeName-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Business - Chennai",
				Keys.ENTER);
		System.out.println("Select college/institute");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Master of Business Administration",
				Keys.ENTER);
		System.out.println("Select degree");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Business Administration", Keys.ENTER);
		System.out.println("Select branch");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("IV", Keys.ENTER);
		System.out.println("Select semester");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		System.out.println("Click on show button");
	}

	@Test
	public void Test3() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFaculty_ctrl0_cbRow")).click();
		System.out.println("checkbox of student1");
		Thread.sleep(1000);
		WebElement Scroll = driver.findElement(By.id("example_filter")); // ID of last
		js.executeScript("arguments[0].scrollIntoView();", Scroll);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFaculty_ctrl1_cbRow")).click();
		System.out.println("checkbox of student2");
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,4000)");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFaculty_ctrl2_cbRow")).click();
		System.out.println("checkbox of student3");
		Thread.sleep(1000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFaculty_ctrl4_cbRow")).click();
		System.out.println("checkbox of student4");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFaculty_ctrl7_cbRow")).click();
		System.out.println("checkbox of student5");
		Thread.sleep(1000);

		WebElement ScrollUp = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")); // ID of last
		js.executeScript("arguments[0].scrollIntoView();", ScrollUp);

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDeptName-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Department of Management Studies",
				Keys.ENTER);
		System.out.println("Select Department of Faculty");
		Thread.sleep(1000);

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdvisor-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(" PRASANNA  S-2021020", Keys.ENTER);
		System.out.println("Select Faculty Advisor");
		Thread.sleep(1000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAssignFA0")).click();
		System.out.println("Faculty Advisor Alloted successfully");

		driver.switchTo().alert().accept();
		driver.close();
	}
}
