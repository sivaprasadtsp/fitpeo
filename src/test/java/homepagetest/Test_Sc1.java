package homepagetest;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Sc1 {
	public static WebDriver driver;
	@BeforeClass
	public void Open_Browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fitpeo.com/");
}
	@Test
	public void Revenue_calculator () throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[3]/div[6]/a/div")).click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500);");
        
        String script = "arguments[0].value = arguments[1]";
        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]"));
        ((JavascriptExecutor) driver).executeScript(script, slider, "820"); 
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
      
       driver.findElement(By.id(":r0:")).sendKeys("560");
        }
        
	
	@Test 
	public void click_checkboxes () throws IOException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500);");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/label/span[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/label/span[1]/input")).click();
File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		
		File destFile = new File("./Screenshots/fitpeo.png");

		FileUtils.copyFile(srcFile, destFile);
		
		driver.close();
	}
	}
