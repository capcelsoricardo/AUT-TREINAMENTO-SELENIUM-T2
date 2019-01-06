package broadleaf.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import broadleaf.pages.HomePage;
import broadleaf.pages.LoginPage;
import treinamento.config.SetUp;

public class TestLogin {
	
	private WebDriver driver;

	@Before
	public void startTest() {
		
		SetUp setUp = new SetUp();
		driver = setUp.createBrowser("CHROME", "https://demo15es5r.broadleafcommerce.org/admin/login");
	}
	
	@Test
	public void realizarLogin(){
	
		LoginPage loginPage = new LoginPage(driver);		
	
		Assert.assertTrue("Página Login NÃO foi apresentada com sucesso.", loginPage.checkPage());
		
		loginPage.realizarLogin("admin", "admin");
		
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue("Login NÁO foi realizado com sucesso.", homePage.checkPage());
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
}