package cenarios.accenture.fiancalocaticia;

import helper.TestHelper;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SC001FiancaLocaticiaPJ extends TestHelper {

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.fiancalocaticia.pj";
	}
	
	@Test
	public void testSC001ResidencialPJ() throws Exception {
		
		// Input
		this.driver.get(this.baseUrl + "novo-portal-web/segurosgerais/massificados/fiancalocaticia/cotacao/input.xhtml");
		
		this.driver.findElement(By.id("formInput:corretor")).clear();
		this.driver.findElement(By.id("formInput:corretor")).sendKeys(getParam("corretor"));		
		preencherCampoTextoSemMascara("formInput:corretor", "corretor");
		capturarTela();
		this.driver.findElement(By.id("formInput:chamar")).click();
		
		// Seguro/Locatario
		esperarElementoCarregado("formSeguroLocatario:inputCnpj");
		selecionarDropDown("formSeguroLocatario:ddlFinalidade", 4);
		preencherCampoTextoSemMascara("formSeguroLocatario:inputCnpj", "cnpj");
		Thread.sleep(2000);
		preencherCampoTextoSemMascara("formSeguroLocatario:razaoSocialProponente", "nome");
		Thread.sleep(3000);
		capturarTela();
		this.driver.findElement(By.id("formSeguroLocatario:btoProximo")).click();
		
		// Locatario/Imovel
		esperarElementoCarregado("frmLocatario:txtDtConstituicao");
		preencherCampoTextoSemMascara("frmLocatario:txtDtConstituicao", "datanascimento");
		preencherCampoTextoSemMascara("frmLocatario:txtFaturamento", "faturamento");
		preencherCampoTextoSemMascara("frmLocatario:nomeBanco1Input", "banco");
		selecionarDropDown("frmLocatario:Select1", 1);
		selecionarDropDown("frmLocatario:ddlSegmento", 1);
		/*this.driver.findElement(By.id("frmLocatario:cep")).clear();
		this.driver.findElement(By.id("frmLocatario:cep")).sendKeys(getParam("cep"));*/
		preencherCampoTextoSemMascara("frmLocatario:txtNumeroImovel", "numero");
		capturarTela();
		this.driver.findElement(By.id("frmLocatario:btoProximo")).click();
		
		// Coberturas
		esperarElementoCarregado("formTelaCoberturas:btoProximo");
		preencherCampoTextoSemMascara("formTelaCoberturas:tableCoberturas:0:inputCobertura", "valorcobertura");
		capturarTela();
		this.driver.findElement(By.id("formTelaCoberturas:btoProximo")).click();
		
		// Calculo
		esperarElementoCarregado("frmCalculoCotacao:btnCalcular");
		selecionarDropDown("frmCalculoCotacao:ddlOperador", 1);
		preencherCampoTextoSemMascara("frmCalculoCotacao:codigoComissao", "operacao");
		this.driver.findElement(By.id("frmCalculoCotacao:btnCalcular")).click();
		Thread.sleep(5000);
		capturarTela();
		this.driver.findElement(By.id("frmCalculoCotacao:btoEfetivar")).click();
		
		// Ficha Cadastral
		
		
		
		
	}
}
