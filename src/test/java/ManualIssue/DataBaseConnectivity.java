package ManualIssue;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class DataBaseConnectivity extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*********Starting Test : " + m.getName() + "******" + "\n");
	}
 
	@Test
	public void dataBaseConnectivity() throws Exception {

		test = reports.createTest("Demand_Creation_Test");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		
		//Data Base Credentails
		//String dbUrl = 
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");


	}
}
