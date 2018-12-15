package mercury.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import mercury.pages.HomePage;
import mercury.pages.LoginPage;
import treinamento.config.SetUp;


public class TestLogin {

	private WebDriver driver;

	@Before
	public void startTest() {
		
		SetUp setUp = new SetUp();
		driver = setUp.createBrowser("CHROME", "http://newtours.demoaut.com/");
	}

	@Test
	public void realizarlogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.realizarLogin("mercury", "mercury");
		 
		HomePage homePage = new HomePage(driver);
		
		Assert.assertTrue("Login N�O foi realizado com sucesso.", homePage.checkPage());
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
