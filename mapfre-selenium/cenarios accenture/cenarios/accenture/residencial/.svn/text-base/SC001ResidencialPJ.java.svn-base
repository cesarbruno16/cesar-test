package cenarios.accenture.residencial;

import static org.junit.Assert.fail;
import helper.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Tela de Segurado - Visualizar o campo CPF/CNPJ Verificar se a máscara do
 * campo CPF/CNPJ se encontra como ___.___.___-__
 * 
 * @author jose.kassimo.junior
 * 
 */
public class SC001ResidencialPJ extends TestHelper {

	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.residencial";
	}

	@Test
	public void testSC001ResidencialPJ() throws Exception {

		this.driver.get(this.baseUrl + "/segurosgerais/massificados/residencial/cotacao/input.xhtml");
				
		// Tela input
		preencherCampoTextoSemMascara("formInput:corretor", "corretor");
		capturarTela();
		this.driver.findElement(By.id("formInput:chamar")).click();
		esperarElementoCarregado("formSeguroResidencial:cpfCnpj");
		
		// Seguro/Segurado
		this.driver.findElement(By.id("formSeguroResidencial:cpfCnpj")).clear();
		this.driver.findElement(By.id("formSeguroResidencial:cpfCnpj")).sendKeys(getParam("cnpj"));
		this.driver.findElement(By.id("formSeguroResidencial:nomeProponente")).clear();
		Thread.sleep(2000);
		this.driver.findElement(By.id("formSeguroResidencial:nomeEmpresa")).sendKeys(getParam("nome"));
		capturarTela();
		this.driver.findElement(By.id("formSeguroResidencial:btoProximo")).click();
	
		// RISCO
		esperarElementoCarregado("formRisco:btoProximo");
		selecionarRadioIdDinamico("formRisco:j_idt87:0:radio", 1);
		selecionarRadioIdDinamico("formRisco:j_idt87:1:radio", 1);		
		selecionarDropDown("formRisco:tipoResidenciaCombo", 1);
		this.driver.findElement(By.id("formRisco:lmiBasica")).clear();
		this.driver.findElement(By.id("formRisco:lmiBasica")).sendKeys(getParam("lmibasica"));
		selecionarDropDown("formRisco:multFranc", 1);
		selecionarDropDown("formRisco:tipoSeguroCombo", 1);
		capturarTela();
		preencherCampoTextoComMascara("formRisco:cep", "cep");
		this.driver.findElement(By.id("formRisco:bairro")).clear();
		Thread.sleep(1000);
		this.driver.findElement(By.cssSelector("span.close.x")).click();		
		preencherCampoTextoSemMascara("formRisco:bairro", "bairro");
		preencherCampoTextoSemMascara("formRisco:logradouro", "logradouro");
		preencherCampoTextoSemMascara("formRisco:numeroResidencia", "numero");
		rolarParaBaixo("formRisco:btoProximo");
		capturarTela();
		this.driver.findElement(By.id("formRisco:btoProximo")).click();		

		// AVALIACAO DE RISCO
		esperarElementoCarregado("formAvaliacaoRisco:btoProximo321");
		capturarTela();
		this.driver.findElement(By.id("formAvaliacaoRisco:btoProximo321")).click();
		
		// COBERTURAS
		esperarElementoCarregado("formCoberturasRE:save");
		selecionarDropDown("formCoberturasRE:tipoSeguro", 1);
		this.driver.findElement(By.id("div_coberturas_adicionais_icon")).click();
		this.driver.findElement(By.id("formCoberturasRE:coberturasAdicionais:0:j_idt164")).clear();
		this.driver.findElement(By.id("formCoberturasRE:coberturasAdicionais:0:j_idt164")).sendKeys(getParam("danoseletricos"));
		capturarTela();
		rolarParaBaixo("formCoberturasRE:save");
		capturarTela();
		this.driver.findElement(By.id("formCoberturasRE:save")).click();
		
		// CALCULO
		esperarElementoCarregado("formCalCotacao:operacao");
		preencherCampoTextoSemMascara("formCalCotacao:operacao", "operacao");
		capturarTela();
		this.driver.findElement(By.id("formCalCotacao:btoCalcular")).click();
		Thread.sleep(10000);
		rolarParaBaixo("formCalCotacao:btoProximo321");
		capturarTela();
		this.driver.findElement(By.id("formCalCotacao:btoProximo321")).click();
		
		// SEGURADO
		selecionarDropDown("formSeguradoResidencial:kitApolice", 1);			
		preencherCampoTextoSemMascara("formSeguradoResidencial:seguradoDDDResidencial", "ddd");
		preencherCampoTextoSemMascara("formSeguradoResidencial:seguradoFoneResidencial", "telefoneres");
		preencherCampoTextoSemMascara("formSeguradoResidencial:email_segurado", "email");
		preencherCampoTextoSemMascara("formSeguradoResidencial:atividadeEconomicaInput", "atividadeeconomica");
		selecionarDropDown("formSeguradoResidencial:paisResidencia", 1);
		capturarTela();
		preencherCampoTextoComMascara("formSeguradoResidencial:cep", "cep");
		Thread.sleep(3000);
		preencherCampoTextoSemMascara("formSeguradoResidencial:bairro", "bairro");
		preencherCampoTextoSemMascara("formSeguradoResidencial:logradouro", "logradouro");
		preencherCampoTextoSemMascara("formSeguradoResidencial:numeroResidencia", "numero");
		rolarParaBaixo("formSeguradoResidencial:btoProximo321");
		capturarTela();
		this.driver.findElement(By.id("formSeguradoResidencial:btoProximo321")).click();
		
		// SEGURO
		esperarElementoCarregado("formSeguroPropostaResidencial:btoProximo321");
		capturarTela();
		this.driver.findElement(By.id("formSeguroPropostaResidencial:btoProximo321")).click();
		
		// COMPLEMENTO DE RISCO
		esperarElementoCarregado("formComplementoRisco:cep");
		capturarTela();		
		selecionarRadioIdDinamico("formComplementoRisco:selectTipoPessoa:1", 1);		
		preencherCampoTextoComMascara("formComplementoRisco:cep", "cepseguro");
		Thread.sleep(2000);
		preencherCampoTextoSemMascara("formComplementoRisco:bairro", "bairro");
		preencherCampoTextoSemMascara("formComplementoRisco:logradouro", "logradouro");
		preencherCampoTextoSemMascara("formComplementoRisco:numeroResidencia", "numero");
		rolarParaBaixo("formComplementoRisco:btoProximo321");
		capturarTela();
		this.driver.findElement(By.id("formComplementoRisco:btoProximo321")).click();
				
		// EFETIVACAO	
		this.driver.findElement(By.id("formEfetivacaoResidencial:formaPagamentoCorretor")).click();
		selecionarDropDown("formEfetivacaoResidencial:formaPagamentoCorretor", 1);
		Thread.sleep(1000);
		selecionarDropDown("formEfetivacaoResidencial:qtdeParcelas", 1);
		Thread.sleep(1000);
		selecionarDropDown("formEfetivacaoResidencial:diaPreferencial", 29);
		capturarTela();
		this.driver.findElement(By.id("formEfetivacaoResidencial:btoEfetivarProposta")).click();				   	
		Thread.sleep(3000);
		capturarTela();

	}

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
