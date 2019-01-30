package br.co.figueira;

public class Propriedades {
	
	public static boolean CLOSE_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.CHROME;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;
	
	public static String NOME_DA_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();
	
	public enum Browsers{
		CHROME,
		FIREFOX,
		IE
	}
	
	public enum TipoExecucao{
		LOCAL,
		NUVEM,
		GRID
		
	}

}