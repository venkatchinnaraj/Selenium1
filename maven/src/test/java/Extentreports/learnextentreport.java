package Extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class learnextentreport {
	@Test
	public void createReport() {
		
	String timestamp = LocalDateTime.now().toString().replace(":", "-");
		//step 1:create ExtentSparkReporter object
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/extentreport.html");
		
		//step 2:create ExtentReports object
		ExtentReports eReport=new ExtentReports();
		
		//step 3:attache Extentsparkreportet to Extentreports
		eReport.attachReporter(spark);
		
		//step 4:ExtentTest object
		ExtentTest test=eReport.createTest("createReport");
		
		//step 5: call log(status ,"message"
		test.log(Status.PASS,"log message added into report");
		
		//step 6:call flush
		eReport.flush();
	}

}
