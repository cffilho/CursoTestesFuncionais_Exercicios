package br.co.figueira.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.co.figueira.BaseTest;
import br.co.figueira.DriveFactory;
import br.co.figueira.pages.LoginPage;

public class TestLoginErro extends BaseTest {
	
	private LoginPage page;
	
	@Before
	public void inicializar() {
		DriveFactory.getDriver().get("https://srbarriga.herokuapp.com/login");
		page = new LoginPage();
		
	}
	
	@Test
	public void acessarErro() {
		
		//inserir dados
		
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("*******");
		page.buttonEntrar();
		
		//verificar se os dados estão corretos
		
		Assert.assertEquals("Problemas com o login do usuário", page.acessError());
	}

}
