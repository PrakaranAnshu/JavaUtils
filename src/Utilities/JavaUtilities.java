package Utilities;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaUtilities {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//PRAKARAN//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//basic window operation
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//enter the URL
		driver.get("https://classic.crmpro.com/index.html");
		//input user name and password
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prakaranverma01");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Anshu@528");	
		//
		WebElement loginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
		//calling static flash function
		flash(loginBtn, driver);
		//loginBtn.click();
		//quit the driver
		//take the screenshot
		File src=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:/Output/output.jpg"));
//		
		
		driver.quit();
		//int number_of_months = 10;

	}
	
	//Highlight the webelement
	public static void flash(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor= element.getCssValue("backgroundColor");
		for(int i = 0; i<=10; i++){
			changeColor("rgb(0,200,0)",element, driver);
			changeColor(bgcolor, element, driver);
			
		}		
	}

//collect the string and put it to sleep
	private static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
