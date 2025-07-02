package home;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class demoextentreport_SS {
@Test
public void login() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("abhis@1234");
	driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
	Thread.sleep(5000);
	//Alert popup = driver.switchTo().alert();
	//popup.accept();
	driver.findElement(By.linkText("Log out")).click();
	String timestamp = LocalDateTime.now().toString().replace(":", "-");
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/"+timestamp+"demo.html");
	ExtentReports eReport=new ExtentReports();
	eReport.attachReporter(spark);
	ExtentTest test=eReport.createTest("login");
	test.log(Status.INFO, "adding screnshot");
	test.addScreenCaptureFromBase64String("demo");
	eReport.flush();
	
	
}
}
