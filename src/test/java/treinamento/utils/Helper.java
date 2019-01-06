package treinamento.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	WebDriver driver_;

	public Helper(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver_ = driver;
	}

	public boolean aguardarElementoClicavel(WebElement elemento, int time) {

		try {
			WebDriverWait wait = new WebDriverWait(driver_, time);
			wait.until(ExpectedConditions.elementToBeClickable(elemento));

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static String getPathDriver(String browser, String so) {
		
		if(so.toUpperCase().contains("MAC")) { 
		
			switch (browser.toUpperCase()) {
				case "CHROME":
					return "src/test/resources/mac/chromedriver";
			
				case "FIREFOX":
					return "src/test/resources/mac/geckodriver";
				
			default:
				return "src/test/resources/mac/chromedriver";
		}
			
		} else {
			
			switch (browser.toUpperCase()) {
				case "CHROME":
					return "src\\test\\resources\\windows\\chromedriver.exe";
				
				case "IE":
					return "src\\test\\resources\\windows\\IEDriverServer.exe";
			
				case "FIREFOX":
					return "src\\test\\resources\\windows\\geckodriver.exe";
			
			default:
				return "src\\test\\resources\\windows\\chromedriver.exe";
			} 
		} 
	}

	public void clickActionWebElement(WebElement elemento) { 
		Actions action = new Actions(driver_);
		
		action.moveToElement(elemento).doubleClick().release().perform();
		
	}

	
	public boolean elementExist(String name) {
		
		List<WebElement> element = driver_.findElements(By.xpath("//a[text()='"+ name +"']"));
		
		return element.size() > 0;	
		
	}
}
