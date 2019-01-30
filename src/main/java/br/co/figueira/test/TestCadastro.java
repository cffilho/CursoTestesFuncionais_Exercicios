package br.co.figueira.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import br.co.figueira.BaseTest;
import br.co.figueira.DriveFactory;
import br.co.figueira.pages.CadastroPage;



public class TestCadastro extends BaseTest {
	
	private CadastroPage page;
	
	@Before
	public void inicializar() {
		
		DriveFactory.getDriver().get("https://srbarriga.herokuapp.com/login");
		page = new CadastroPage();
	}
	
	@Test
	public void cadastroNomeObrigatorio() {
		//clicar no botão cadastrar
		
		page.cadastrarUsuario();
				
		//preencher dados
		
		page.setName("");
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("123456");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Nome é um campo obrigatório", page.cadastroError());
	}
	
	@Test
	public void cadastroEmailObrigatorio() {
		//clicar no botão cadastrar
		
		page.cadastrarUsuario();
				
		//preencher dados
		
		page.setName("Maria");
		page.setEmail("");
		page.setPassword("123456");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Email é um campo obrigatório", page.cadastroError());
	}
	
	@Test
	public void cadastroSenhaObrigatorio() {
		//clicar no botão cadastrar
		
		page.cadastrarUsuario();
				
		//preencher dados
		
		page.setName("Maria");
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Senha é um campo obrigatório", page.cadastroError());
	}
	
	@Test
	@Ignore
	public void novoCadastro() {
		
		//clicar no botão cadastrar
		
		page.cadastrarUsuario();
		
		//preencher dados
		
		page.setName("Maria");
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("123456");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Usuário inserido com sucesso", page.cadastroSuccess());
	}

}
