package treinamento.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import static treinamento.utils.Helper.getPathDriver;;
public class SetUp {
	
	
	public WebDriver driver;
	
	public WebDriver createBrowser(String browser, String url) {
		
		switch (browser.toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", getPathDriver( "CHROME", System.getProperty("os.name")));
				driver = new ChromeDriver();
			break;
			
			case "IE":
				System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			break;
		
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			break;
			
			default:
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			break;
		}
		
		driver.get(url);
		if(System.getProperty("os.name").contains("Mac"))
			driver.manage().window().fullscreen();
		else
			driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Espera implicita
		
		return driver;
	}
	
	

}
