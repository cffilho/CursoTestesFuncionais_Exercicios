package br.co.figueira.test;

import org.junit.Assert;
import org.junit.Test;

import br.co.figueira.BaseTest;
import br.co.figueira.pages.ContasPage;
import br.co.figueira.pages.MenuPage;



public class TestExcluirContaComMovimentação extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void excluirContaComMovimentacao() {
		
		menuPage.listarConta();
		
		contasPage.removerConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.mensagemDeErro());
		
	}

}
