package cars;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class rollsroyceTest {
	@Test
	public void launch() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://www.rolls-roycemotorcars.com/en_GB/home.html");
	Reporter.log("Rollsroyce is launched",true);
	
	}

}
