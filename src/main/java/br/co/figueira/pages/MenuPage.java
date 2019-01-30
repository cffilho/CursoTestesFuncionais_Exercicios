package br.co.figueira.pages;

import br.co.figueira.BasePage;

public class MenuPage extends BasePage {
	
	public void home() {
		dsl.clicarLink("Home");
	}
	
	public void adicionarConta() {
		dsl.clicarLink("Contas");
		dsl.clicarLink("Adicionar");
		
	}
	
	public void listarConta() {
		dsl.clicarLink("Contas");
		dsl.clicarLink("Listar");
	}
	
	public void criarMovimentacao() {
		dsl.clicarLink("Criar Movimentação");
	}
	
	public void resumoMensal() {
		dsl.clicarLink("Resumo Mensal");
	}
	
	public void sair() {
		dsl.clicarLink("Sair");
	}
	
}
