package treinamento.utils;

import static treinamento.utils.Helper.getPathDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
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
}
