package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_PTPFDeductionReport_GrossTDSReport;
import Payroll.AL_Payroll_Rpt_StaffWiseSalaryData;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;
import utility.ExcelUtility;

public class AL_Payroll_Rpt_StaffWiseSalaryDataTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	ExcelUtility excelutilitytest;
	AL_Payroll_Rpt_StaffWiseSalaryData staff_sal;
	HomePageAdmin HP;
	
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
	public void aL_Payroll_Rpt_StaffWiseSalaryDataTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> Staff wise Salary data");
		
		staff_sal = new AL_Payroll_Rpt_StaffWiseSalaryData(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Payroll_Rpt_StaffWiseSalaryDataTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		
		Thread.sleep(2000);
		staff_sal.Reports();
		
		Thread.sleep(2000);
		staff_sal.StaffWiseSalarydata();
		
		Thread.sleep(2000);
		staff_sal.Select_month();
		
		Thread.sleep(2000);
		staff_sal.Select_college();
		
		Thread.sleep(2000); 
		staff_sal.Select_Staff();
		
		Thread.sleep(3000);
		staff_sal.Click_showToExportInToExcelFile_btn();
		
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("Mr. MOHAMMED ABUBACKER MR","AbstractRegisterDeptGroupTotal"); 
		}
}
