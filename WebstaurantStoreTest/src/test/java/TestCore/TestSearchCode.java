package TestCore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSearchCode {

	public static void main(String[] args) {
		
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.webstaurantstore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.xpath("//div[contains(@class,'hidden flex-1 ml-0 lt:flex max-w-//input[@id='searchval']")).sendKeys("");
		
		driver.findElement(By.xpath("//*[@id=\"searchval\"]")).sendKeys("stainless work table");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Use executeScript with "window.scrollTo" to scroll to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		List<WebElement> results =  driver.findElements(By.cssSelector("#ProductBoxContainer"));
		
		
		for (WebElement result : results) {
		    // Perform actions on each element here
		    // For example, get the text of each element
		    String titleText = result.findElement(By.cssSelector("div.group.border-transparent.border-solid > a > span")).getText();
		    
		    if(titleText.toLowerCase().contains("table")){
		    	result.findElement(By.cssSelector("div.add-to-cart > form > div > div > input.btn.btn-cart.btn-small")).click();
		    	
		    	driver.findElement(By.cssSelector("#watnotif-wrapper > div")).click();
//		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//		    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#watnotif-wrapper > div"))).click();

		    }
		    
		}

		
		
		
		
		
		

	}

}
