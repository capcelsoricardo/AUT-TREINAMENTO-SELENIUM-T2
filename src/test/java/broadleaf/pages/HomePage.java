package broadleaf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Welcome')]")
	private WebElement linkWelcome;
	
	public boolean checkPage(){
		return linkWelcome.isDisplayed();
	}
}