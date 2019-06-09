package LiveMatch;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotStar {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//PRAKARAN//Downloads//chromedriver_win32//chromedriver.exe");
		//int counter= 1;
		
		while(true){
			
			driver = new ChromeDriver();
			driver.get("https://www.hotstar.com/sports/cricket/icc-cricket-world-cup-england-and-wales-2019/bangladesh-vs-new-zealand-m190719/live-streaming/1440000687");
			driver.manage().window().maximize();
					
			//getTheUrl();
			Thread.sleep(1000*5*60);
			//driver.navigate().refresh();
			//Refresh
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("history.go(0)");
			driver.close();
			
						
		}
	}
//
//	private static void getTheUrl() {
//		// TODO Auto-generated method stub
//		
//		
//	}
//	

}
