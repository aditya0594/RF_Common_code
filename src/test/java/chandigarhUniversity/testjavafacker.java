package chandigarhUniversity;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.github.javafaker.DateAndTime;
//import com.github.javafaker.Faker;

import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class testjavafacker extends BaseClass{
	private WebDriver driver;

	ExtentReports reports;
	ExtentTest test;

	// AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	@Test
	public void testjavafackerTest() throws Exception {

     /*  Faker faker = new Faker();

        // Generate fake data
        String fakeName = faker.name().fullName();
        String fakeEmail = faker.internet().emailAddress();
        String fakeAddress = faker.address().fullAddress();
        DateAndTime date = faker.date();*/
        

        try {

			/*
			 * // Fill the form with fake data WebElement nameField =
			 * driver.findElement(By.id("name")); nameField.sendKeys(fakeName);
			 * 
			 * WebElement emailField = driver.findElement(By.id("email"));
			 * emailField.sendKeys(fakeEmail);
			 * 
			 * WebElement addressField = driver.findElement(By.id("address"));
			 * addressField.sendKeys(fakeAddress);
			 * 
			 * // Submit the form WebElement submitButton =
			 * driver.findElement(By.id("submit")); submitButton.click();
			 * */
       /* 	System.out.println(fakeName);
        	System.out.println(fakeEmail);
        	System.out.println(fakeAddress);*/
        	

            // Optional: Add validation or assertions here

        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}