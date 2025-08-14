package pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BaseClass;

public class Browser extends BaseClass {

	public static Map<String, Object> vars;
	public static JavascriptExecutor js;
	public static Properties prop;
	InputStream inputStream;

	@SuppressWarnings("deprecation")
	public static WebDriver openBrowser(String url) throws Exception {
		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");

			prop.load(fis);
			String browserName = prop.getProperty("browser"); 
			System.out.println(browserName);

			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
						
				ChromeOptions options = new ChromeOptions();
				HashMap<String, Object> prefs = new HashMap<String, Object>();

			//	String path = String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"documentsForTesting"+File.separator+filename;
				String downloadPath = System.getProperty("user.dir")+File.separator+"DownloadPDFs";
				prefs.put("download.default_directory", downloadPath); 
				options.setExperimentalOption("prefs", prefs);
						
				driver = new ChromeDriver(options);
				js = (JavascriptExecutor) driver;
				vars = new HashMap<String, Object>();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				js = (JavascriptExecutor) driver;
				vars = new HashMap<String, Object>();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				js = (JavascriptExecutor) driver;
				vars = new HashMap<String, Object>(); 
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get(prop.getProperty(url));

			driver.manage().window().maximize();

		} catch (Exception e) {

			System.out.println(e.getCause());
			System.out.println(e.getMessage());

			throw e;

		}
		return driver;

	}

}
