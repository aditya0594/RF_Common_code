package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.remote.CapabilityType;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import static RFCCAcademic.AL_Academic_AP_NewStudent.waitForVisibilityBy;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	public static final long Wait = 30;
	

	public WebDriver intializeBrowser(String url) throws Exception {

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties"); 

			prop.load(fis);
			String browserName = prop.getProperty("browser");
			System.out.println(browserName);

			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=2560,1440");
				options.addArguments("profile-directory=Default");// avoids resizing delay
				options.addArguments("--disable-blink-features=AutomationControlled"); // less detection
				options.addArguments("--disable-extensions"); // no extensions
				options.addArguments("--disable-infobars"); // hide "Chrome is being controlled"
				options.addArguments("--disable-gpu"); // skip GPU overhead
				options.addArguments("--no-sandbox"); // faster in test environments
				options.addArguments("--disable-background-networking"); // no background fetches
				options.addArguments("--disable-background-timer-throttling");
				options.addArguments("--disable-backgrounding-occluded-windows");
				options.addArguments("--disable-renderer-backgrounding");
				options.addArguments("--start-maximized");
				options.addArguments("user-data-dir=C:/Users/HM/AppData/Local/Google/Chrome/User Data");
				options.addArguments("profile-directory=Default");// avoids resizing delay

				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.managed_default_content_settings.images", 2); // block images
				prefs.put("profile.managed_default_content_settings.stylesheets", 2); // block CSS
				options.setExperimentalOption("prefs", prefs);

				driver = new ChromeDriver(options);
			} else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup(); 
				driver = new FirefoxDriver();
			} else if (browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
				driver.get(prop.getProperty(url));

				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();

			}

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage()); 
			throw e;
		}

		return driver;
	}

	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
//	public static void waitForVisibilityBy(By e) {
//		WebElement e1 = driver.findElement(e);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(e1));
//	}

	public void waitUntilElementIsClickable(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Wait));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	/*public static void waitUntilElementIsClickableBy(By e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Wait));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}*/

	public void click(WebElement e) {
		waitForVisibility(e);
		waitUntilElementIsClickable(e);
		e.click();
	}
	public void clickBy(By e) {
		WebElement e1 = driver.findElement(e);
		e1.click();
	}

	public void sendKeys(WebElement e, String text) {
		waitForVisibility(e);
		e.sendKeys(text);
	}
//	public static void sendKeysBy(By e, String text) {
//		waitForVisibilityBy(e);
//		driver.findElement(e).sendKeys(text);
//	}

	public void clearText(WebElement e) {
		waitForVisibility(e);
		e.clear();
	}
	public void clearTextBy(By e) {
		waitForVisibilityBy(e);
		driver.findElement(e).clear();

	}

	public String getAttribute(WebElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(WebElement e) {
		waitForVisibility(e);
		return e.getText();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateRefresh() {
		driver.navigate().refresh();
	}

	public void threadWait1() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void threadWait2() throws InterruptedException {
		Thread.sleep(8000);
	}

	public void threadWait3() throws InterruptedException {
		Thread.sleep(5000);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public String getCurrentTime() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormate = new SimpleDateFormat("dd:mm a");
		Date date = new Date(); // get current date time in date
		String date1 = dateFormate.format(date); // Now format the date
		return date1;
	}

	public String getCurrentDate() {
		DateFormat dateFormate = new SimpleDateFormat("dd-MM-yyyy"); // dd-MM-yyyy
		Date date = new Date();
		String date1 = dateFormate.format(date);
		return date1;
	}

	public String getCurrentDateAndTime() {
		DateFormat dateFormate = new SimpleDateFormat("ddMMyyyy_HHmmss");
		Date date = new Date();
		String dagetCurrentdateAndtimete1 = dateFormate.format(date);
		return dagetCurrentdateAndtimete1;
	}

	public static String generateFirstName() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		return firstName;

	}
	public static String generateLastName() {
		Faker faker = new Faker();
		String lastName = faker.name().lastName();
		return lastName;
	}

	public static String Random4DigitString() {
		Random random = new Random();
		int randomNumber = 1000 + random.nextInt(9000); // 1000 to 9999
		return String.valueOf(randomNumber);
	}

	public static void dropdownByEnter(By element,By textfield, String option) throws InterruptedException {
		driver.findElement(element).click();
		driver.findElement(textfield).sendKeys(option);
		driver.findElement(textfield).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		//driver.findElement(textfield).sendKeys(Keys.TAB);
	}
	public static String generateMobileNumber() {
		Random random = new Random();

		// First digit between 6 and 9 to make it look realistic (like Indian mobile numbers)
		int firstDigit = 3 + random.nextInt(7); // 6, 7, 8, or 9
		StringBuilder number = new StringBuilder();
		number.append(firstDigit);

		// Append the remaining 9 digits (0 to 9)
		for (int i = 0; i < 9; i++) {
			number.append(random.nextInt(10));
		}

		return number.toString();
	}

	public static void waitForElementVisible(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void scrollIntoView(WebElement e, int up, int down) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + up + "," + down + ")");
	}

	public void scrollIntoElement(WebElement e) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
	}
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * Scroll into view of the element found by the given By object.
	 *
	 * @param e The By object to find the element to scroll into view.
	 */
/* <<<<<<<<<<  c8258be0-2af2-47bb-9cca-9a81b26832cd  >>>>>>>>>>> */
	public void scrollIntoElementBy(By e) {
		WebElement element = driver.findElement(e);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Wait));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert : " + driver.switchTo().alert().getText() + " - Yes");
		alert.accept();
	}

	public void dismissAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Wait));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert : " + driver.switchTo().alert().getText() + " -No");
		alert.dismiss();
	}

	public void switchToNextWindow() {
		Set<String> windowPopUp = driver.getWindowHandles();
		Iterator<String> iterate = windowPopUp.iterator();
		List<String> windex = new ArrayList<String>(); 
		while (iterate.hasNext()) {
			windex.add(iterate.next());
		}
		driver.switchTo().window(windex.get(1));
		//driver.manage().window().maximize();
		System.out.println(windowPopUp.size() + " - WindowPopUp : Switch To Window");
		System.out.println("                   Current Url" + driver.getCurrentUrl());
		System.out.println("                   Window Title - " + driver.getTitle());
		System.out.println("                   Window Id" + windex.get(1));
	}

	public void switchToFrame(int frameNum) { // Function for switch the window
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(totalFrames);
		driver.switchTo().frame(frameNum);
	}

	public void switchToDefaultContent(int frameNum) {
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(totalFrames);
		driver.switchTo().defaultContent();
	}
	
	public void switchToFrameOrDefault() {
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(currentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
	
	public static void captureScreenshot(WebDriver driver, String testName) {
		// Format the date and time for the screenshot name
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("ScreenshotsOfReports/" + testName + "_" + timestamp + ".png");

		// Create the directory if it doesn't exist
		if (!destFile.getParentFile().exists()) {
		destFile.getParentFile().mkdirs();
		}

		try {
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
		System.out.println("Exception while saving screenshot: " + e.getMessage());
		}
		}
}
