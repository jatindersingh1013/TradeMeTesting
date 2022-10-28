package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class Launch {
	WebDriver driver;
	String url = "https://www.trademe.co.nz/a/";
	
	
	@BeforeTest
	public void openBrowser(){
//        System.setProperty("webdriver.chrome.driver", "C://Windows//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
		driver.manage().window().maximize();

	driver.get(url);
	driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-dynamic-homepage/tm-homepage-search-header/nav/div[2]/ul/li[3]/a")).click();	
	}
	

	@Test
	public void make() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1,900)");
		Thread.sleep(2000);		
		WebElement ele = driver.findElement(By.name("selectedMake"));
		
		Select sel = new Select(ele);
		sel.selectByValue("0: undefined");
	
		Thread.sleep(5000);
		
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,500)");
		sel.selectByVisibleText("BMW ");

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-motors-home-page/tm-motors-home-page-header/div/div/tm-motors-search-form/form/tm-motors-used-cars-mobile/div[2]/button")).click();
	}

	
	
    @AfterTest
    public void closeWindow() {
    driver.close();
    }
	}
