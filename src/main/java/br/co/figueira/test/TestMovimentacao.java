package br.co.figueira.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.co.figueira.BaseTest;
import br.co.figueira.pages.CriarMovimentacaoPage;
import br.co.figueira.pages.MenuPage;




public class TestMovimentacao extends BaseTest {

	MenuPage menuPage = new MenuPage();
	CriarMovimentacaoPage movPage = new CriarMovimentacaoPage();
	
	@Test
	public void atest1_InserirMovimentacao() {
		
		menuPage.criarMovimentacao();
		
		movPage.setTipoMovimentacao("Receita");
		movPage.setDataMovimentacao("01/01/2019");
		movPage.setDataPagamento("22/01/2019");
		movPage.setDescricao("Movimenta��o1");
		movPage.setInteressado("Sr.Barriga");
		movPage.setValor("700");
		movPage.setConta("Conta para movimentacoes");
		movPage.setPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.mensagemDeConfirma��o());
	}
	
	@Test
	public void btest2_CamposObrigatorios(){
		
		menuPage.criarMovimentacao();
		
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio", "Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio", "Interessado � obrigat�rio", 
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void ctest3_MovimentacaoFutura() {
		
menuPage.criarMovimentacao();
		
		movPage.setTipoMovimentacao("Receita");
		movPage.setDataMovimentacao("01/01/2118");
		movPage.setDataPagamento("22/01/2118");
		movPage.setDescricao("Nova Movimenta��o de receita paga");
		movPage.setInteressado("Sr.Barriga");
		movPage.setValor("700");
		movPage.setConta("Conta para movimentacoes");
		movPage.setPago();
		movPage.salvar();
		
		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", movPage.mensagemDeErro());
	}

}
