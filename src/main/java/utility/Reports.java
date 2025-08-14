package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports createReport() {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("extentreports.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Created By", "Deepak");
		reports.setSystemInfo("Type", "Regression");
		return reports;

}
}
