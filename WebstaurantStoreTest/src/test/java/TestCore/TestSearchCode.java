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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@href='/search/stainless-work-table.html?page=9']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

// Use executeScript with "window.scrollTo" to scroll to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

//get the last one

		driver.findElement(By.xpath("(//input[@class='btn btn-cart btn-small'])[last()]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//Go to ViewCart
		driver.findElement(By.xpath("//a[@href='/viewcart.cfm']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//Click on the Empty Cart
		driver.findElement(By.xpath("//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//click Empty cart "PopUp"
		driver.findElement(By.xpath(
				"//button[@class='border-solid border box-border cursor-pointer inline-block text-center no-underline antialiased focus-visible:outline focus-visible:outline-offset-2 focus-visible:outline-2 mr-2 rounded-normal text-base leading-normal px-7 py-2-1/2 hover:bg-green-800 text-white text-shadow-black-60 bg-green-500 border-black-10 focus-visible:outline-green-800 btn align-middle font-semibold']"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.quit();

	}

}