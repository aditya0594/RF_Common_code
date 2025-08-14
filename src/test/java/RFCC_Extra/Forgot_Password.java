package RFCC_Extra;

import java.lang.reflect.Method;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Forgot_Password extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void ForgotPassword() throws Exception {

		RF_AdminLoginPage.loginPage();


		System.out.println("Browser open succesfully");
		driver.get("https://jecrcuat.mastersofterp.in/");
		System.out.println("Link executed succefully"); 
		
		Thread.sleep(2000);
		WebElement btn_frgtpass = driver.findElement(By.id("lbtForgePass"));
		btn_frgtpass.click();
		Thread.sleep(2000);
		
		WebElement btn_redo = driver.findElement(By.id("rdoUsername"));
		btn_redo.click();
		Thread.sleep(2000);
		
		WebElement btn_remail = driver.findElement(By.id("rdoEmail"));
		btn_remail.click();
//driver.findElement(By.id("txtEmail")).click();
		Thread.sleep(2000);
		
		WebElement btn_email = 	driver.findElement(By.id("txtEmail"));
		btn_email.sendKeys("pratikmsoft@gmail.com");
		driver.findElement(By.id("benotop2")).click();
		System.out.println("Mail OTP Verified Succesfully");  
		
		Thread.sleep(2000);
		acceptAlert();
		
		Thread.sleep(20000);
		WebElement btn_votp = driver.findElement(By.id("btnVerifyEmailOtp"));
		btn_votp.click();
		
		Thread.sleep(2000);
		acceptAlert();
		
		Thread.sleep(2000);
		WebElement mob = driver.findElement(By.id("rdoMobile"));
		mob.click();
		
		Thread.sleep(2000);
		WebElement txt_mob = driver.findElement(By.id("txtMobile"));
		txt_mob.sendKeys("8788081370");
		
		Thread.sleep(1000);
		WebElement btn_sotp = driver.findElement(By.id("btnSendotp"));
		btn_sotp.click();
		
		Thread.sleep(1000);
		acceptAlert();
		
		Thread.sleep(10000);
		WebElement btn_mverify = driver.findElement(By.id("btnMobOtpVerify"));
		btn_mverify.click();
		
		Thread.sleep(2000);
		acceptAlert();
		
		Thread.sleep(2000);
		WebElement btn_clsepop = driver.findElement(By.id("clsepop"));
		btn_clsepop.click();
		System.out.println("cancel button click succesfully");
		
		Thread.sleep(2000);
		WebElement btn_frgtpasss = driver.findElement(By.id("lbtForgePass"));
		btn_frgtpasss.click();
		
		Thread.sleep(2000);
		WebElement pass = driver.findElement(By.id("rdoPassword"));
		pass.click();
		
		Thread.sleep(1000);
		WebElement remail = driver.findElement(By.id("rdoEmail"));
		remail.click();
		
		Thread.sleep(1000);
		WebElement txt_email = driver.findElement(By.id("txtEmail"));
		txt_email.sendKeys("pratikmsoft@gmail.com");
		
		Thread.sleep(2000);
		WebElement btn = driver.findElement(By.id("benotop2"));
		btn.click();
		
		Thread.sleep(2000);
		acceptAlert();
		
		Thread.sleep(20000);
		WebElement btn_verifyemailotp = driver.findElement(By.id("btnVerifyEmailOtp"));
		btn_verifyemailotp.click();
		System.out.println("Password OTP verified succefully");
		
		Thread.sleep(20000);
		WebElement btn_senduserpass = driver.findElement(By.id("btnSendUsernamePassword"));
		btn_senduserpass.click();
		
		Thread.sleep(2000);
		WebElement btn_close = driver.findElement(By.id("btnclosepop"));
		btn_close.click();

		// System.out.println("");*/
	}

}
