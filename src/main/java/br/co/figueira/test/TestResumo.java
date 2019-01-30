package br.co.figueira.test;

import org.junit.Assert;

import org.junit.Test;
import br.co.figueira.BaseTest;
import br.co.figueira.pages.MenuPage;
import br.co.figueira.pages.ResumoPage;



public class TestResumo extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ResumoPage resPage = new ResumoPage();
	
	@Test
	public void testRemoverMovimentacao() {
		
		menuPage.resumoMensal();
		
		resPage.removerMovimentacao();
		
		Assert.assertEquals("Movimenta��o removida com sucesso!", resPage.mensagemDeConfirma��o());
		
	}
	
	/*
	 * 
	@Test
	public void removerMovimentacaoSelecionandoMes() {
		
		menuPage.resumoMensal();
		
		resPage.setMes("Janeiro");
		resPage.setAno("2018");
		resPage.buscar();
		
		resPage.removerMovimentacao();
		
		Assert.assertEquals("Movimenta��o removida com sucesso!", resPage.mensagemDeConfirma��o());
		
	}
	
	
	
	@Test
	public void removerMovimentacaoPorDescricao() {
		
		menuPage.resumoMensal();
		
		resPage.removerMovimentacaoDescricao("Movimenta��o1");
		
		Assert.assertEquals("Movimenta��o removida com sucesso!", resPage.mensagemDeConfirma��o());
		
	}
	
	*/

}
