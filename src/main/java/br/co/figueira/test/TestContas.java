package br.co.figueira.test;

import org.junit.Assert;
import org.junit.Test;

import br.co.figueira.BaseTest;
import br.co.figueira.pages.ContasPage;
import br.co.figueira.pages.MenuPage;



public class TestContas extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void atest1_AdicionarConta() {
		
		menuPage.adicionarConta();
		
		contasPage.adicionarNome("Conta do Adriano");
		contasPage.clicarSalvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.mensagemDeConfirmação());
		
		
	}
	
	@Test
	public void btest2_AlterarConta() {
		
		menuPage.listarConta();
		
		contasPage.alterarConta("Conta para alterar");
		contasPage.adicionarNome("Conta alterada");
		contasPage.clicarSalvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.mensagemDeConfirmação());
		
	}
	
	@Test
	public void ctest3_InserirContaComMesmoNome() {
		
		menuPage.adicionarConta();
		
		contasPage.adicionarNome("Conta mesmo nome");
		contasPage.clicarSalvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.mensagemDeErro());
	}
	
	/*
	@Test
	public void alterarContaComMesmoNome() {
		
		menuPage.listarConta();
		
		contasPage.alterarConta("Teste2");
		contasPage.adicionarNome("Teste");
		contasPage.clicarSalvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.mensagemDeErro());
	}	
	
	@Test
	public void removerConta() {
		
		menuPage.listarConta();
		
		contasPage.removerConta("Conta da Maria");
		
		Assert.assertEquals("Conta removida com sucesso!", contasPage.mensagemDeConfirmação());
	}
	
	
	
	@Test
	public void excluirContaComMovimentacao() {
		
		menuPage.listarConta();
		
		contasPage.removerConta("Conta do Antonio");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.mensagemDeErro());
		
	}
	
	*/
	
}
