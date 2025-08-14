package EstablishmentTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_EmployeePunchStatus;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Establishment_Rpt_EmployeePunchStatusTest extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    AL_Establishment_Rpt_EmployeePunchStatus employeePunchStatus;
    HomePageAdmin HP;
    PDFUtility pdfutility;
	
	
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
    public void aL_Establishment_Rpt_EmployeePunchStatusTest() throws Exception {
        employeePunchStatus = new AL_Establishment_Rpt_EmployeePunchStatus(driver);
   
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Establishment_Rpt_EmployeePunchStatusTest");
        pdfutility =new PDFUtility(driver);	

        RF_AdminLoginPage.loginPage();
        System.out.println("ESTABLISHMENT > REPORTS > Employee Punch Status");

        threadWait1();
        HP.ESTABLISHMENT();

    	Thread.sleep(5000);
    	employeePunchStatus.click_Report();

        threadWait1();
        employeePunchStatus.Click_EmployeePunchStatus();

        threadWait1();
        employeePunchStatus.Select_College();
        
        threadWait1();
        employeePunchStatus.Select_StaffType();
        
        threadWait1();
        employeePunchStatus.Enter_FromDate();
        
        threadWait1();
        employeePunchStatus.Enter_ToDate();
        
        threadWait1();
        employeePunchStatus.Click_ReportButton();
        
        System.out.println("Employee Punch Status report generated successfully");
        
    	Thread.sleep(5000);
    	pdfutility.downloadPDF(driver, "Establishment - Employee Punch Status report");
    	Thread.sleep(5000);
    	pdfutility.readPDF("Establishment - Employee Punch Status report", "NAZNEEN");	

    }
}
