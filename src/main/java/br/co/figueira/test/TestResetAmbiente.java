package br.co.figueira.test;


import org.junit.Test;

import br.co.figueira.BaseTest;
import br.co.figueira.pages.HomePage;
import br.co.figueira.pages.MenuPage;

public class TestResetAmbiente extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void testResetarAmbiente() {
		
		menuPage.home();
		
		homePage.clicarReset();
		
	}

}
