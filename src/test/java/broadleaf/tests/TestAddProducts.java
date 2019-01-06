package broadleaf.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import broadleaf.pages.AddOnProductsPage;
import broadleaf.pages.HomePage;
import broadleaf.pages.LoginPage;
import broadleaf.pages.MenuPage;
import treinamento.config.SetUp;

public class TestAddProducts {

	private WebDriver driver;

	@Before
	public void startTest() {

		SetUp setUp = new SetUp();
		driver = setUp.createBrowser("CHROME", "https://demo15es5r.broadleafcommerce.org/admin/login");
	}

	@Test
	public void adicionarProduto() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.realizarLogin("admin", "admin");

		HomePage homePage = new HomePage(driver);
		Assert.assertTrue("Login NÃO foi realizado com sucesso.", homePage.checkPage());

		MenuPage menuPrincipal = new MenuPage(driver);
		menuPrincipal.clickMenuCatalogAddOnProducts();

		AddOnProductsPage addOnProductsPage = new AddOnProductsPage(driver);
		Assert.assertTrue("Página Add On Products NÃO apresentada com sucesso", addOnProductsPage.checkPage());

		addOnProductsPage.incluirProduto("Panetone", "Panetone Caro", "Visconde", "Top", "200", "500", "200");

		Assert.assertTrue("Mensagem Successfully saved NÃO foi apresentada com sucesso.",
				addOnProductsPage.checkMensagemInclusaoComSucesso());

		menuPrincipal.clickMenuCatalogAddOnProducts();
		
		Assert.assertTrue("Registro NAO foi incluido com sucesso.",
				addOnProductsPage.checkRegistroIncluido("Panetone"));
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
