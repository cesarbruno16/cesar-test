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
 * @author leonardo.panta.leao
 * 
 */
public class SC001ResidencialPF extends TestHelper {

	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.residencial";
		setUser("ivson.santos");
	}

	@Test
	public void testSC001ResidencialPF() throws Exception {
		
		// SEGURO SEGURADO
		this.driver.get(this.baseUrl + "/segurosgerais/massificados/residencial/cotacao/index.xhtml?cod_cotacao=0&cod_corretor=71503&acao=NOVO&desPac=seguroSegurado@cod_cotacao=30404629680486783");
		Thread.sleep(2000);
		capturarTela();		
		this.driver.findElement(By.id("formSeguroResidencial:cpfCnpj")).clear();
		this.driver.findElement(By.id("formSeguroResidencial:cpfCnpj")).sendKeys(getParam("cpf"));
		this.driver.findElement(By.id("formSeguroResidencial:nomeProponente")).clear();
		Thread.sleep(5000);
		this.driver.findElement(By.id("formSeguroResidencial:nomeProponente")).sendKeys(getParam("nome"));
		this.driver.findElement(By.id("formSeguroResidencial:btoProximo")).click();
		
		
		// RISCO
		Thread.sleep(2000);
		capturarTela();
		selecionarRadioIdDinamico("formRisco:j_idt87:0:radio", 1);
		selecionarRadioIdDinamico("formRisco:j_idt87:1:radio", 1);		
		selecionarDropDown("formRisco:tipoResidenciaCombo", 1);
		this.driver.findElement(By.id("formRisco:lmiBasica")).clear();
		this.driver.findElement(By.id("formRisco:lmiBasica")).sendKeys(getParam("lmibasica"));
		selecionarDropDown("formRisco:multFranc", 1);
		selecionarDropDown("formRisco:tipoSeguroCombo", 1);
		this.driver.findElement(By.id("formRisco:cep")).clear();
		this.driver.findElement(By.id("formRisco:cep")).sendKeys(getParam("cep"));
		this.driver.findElement(By.id("formRisco:bairro")).clear();
		Thread.sleep(1000);
		this.driver.findElement(By.cssSelector("span.close.x")).click();		
		this.driver.findElement(By.id("formRisco:bairro")).sendKeys(getParam("bairro"));
		this.driver.findElement(By.id("formRisco:logradouro")).clear();
		this.driver.findElement(By.id("formRisco:logradouro")).sendKeys(getParam("logradouro"));
		this.driver.findElement(By.id("formRisco:numeroResidencia")).clear();
		this.driver.findElement(By.id("formRisco:numeroResidencia")).sendKeys(getParam("numero"));
		this.driver.findElement(By.id("formRisco:btoProximo")).click();		

		// AVALIACAO DE RISCO
		Thread.sleep(3000);
		capturarTela();
		this.driver.findElement(By.id("formAvaliacaoRisco:btoProximo321")).click();
		
		// COBERTURAS
		Thread.sleep(3000);
		capturarTela();
		selecionarDropDown("formCoberturasRE:tipoSeguro", 1);
		this.driver.findElement(By.id("div_coberturas_adicionais_icon")).click();
		this.driver.findElement(By.id("formCoberturasRE:coberturasAdicionais:0:j_idt164")).clear();
		this.driver.findElement(By.id("formCoberturasRE:coberturasAdicionais:0:j_idt164")).sendKeys(getParam("danoseletricos"));
		this.driver.findElement(By.id("formCoberturasRE:save")).click();
		
		
		// CALCULO
		Thread.sleep(2000);
		capturarTela();
		selecionarDropDown("formCalCotacao:operador", 1);
		this.driver.findElement(By.id("formCalCotacao:operacao")).clear();
		this.driver.findElement(By.id("formCalCotacao:operacao")).sendKeys(getParam("operacao"));
		this.driver.findElement(By.id("formCalCotacao:btoCalcular")).click();
		Thread.sleep(10000);
		this.driver.findElement(By.id("formCalCotacao:btoProximo321")).click();
		
		// SEGURADO
		Thread.sleep(2000);
		capturarTela();
		selecionarDropDown("formSeguradoResidencial:kitApolice", 1);			
		this.driver.findElement(By.id("formSeguradoResidencial:dataNascimento")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:dataNascimento")).sendKeys(getParam("datanascimento"));
		selecionarRadioIdDinamico("formSeguradoResidencial:sexo:1", 1);		
		selecionarDropDown("formSeguradoResidencial:estadoCivil", 1);
		this.driver.findElement(By.id("formSeguradoResidencial:atividadeSeguradoInput")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:atividadeSeguradoInput")).sendKeys(getParam("atividade"));		
		selecionarDropDown("formSeguradoResidencial:rendaMensal", 1);
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoDDDResidencial")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoDDDResidencial")).sendKeys(getParam("ddd"));
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoFoneResidencial")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoFoneResidencial")).sendKeys(getParam("telefoneres"));
		this.driver.findElement(By.name("formSeguradoResidencial:j_idt174")).clear();
		this.driver.findElement(By.name("formSeguradoResidencial:j_idt174")).sendKeys(getParam("ddd"));
		this.driver.findElement(By.name("formSeguradoResidencial:j_idt175")).clear();
		this.driver.findElement(By.name("formSeguradoResidencial:j_idt175")).sendKeys(getParam("telefonecelular"));
		this.driver.findElement(By.id("formSeguradoResidencial:email_segurado")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:email_segurado")).sendKeys(getParam("email"));
		selecionarDropDown("formSeguradoResidencial:tipoDocumento", 5);
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoNumeroDocumento")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoNumeroDocumento")).sendKeys(getParam("numerodoc"));
		selecionarDropDown("formSeguradoResidencial:orgaoExpedidorSegurado", 1);
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoDataExpedicao")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:seguradoDataExpedicao")).sendKeys(getParam("dataexpedicao"));
		this.driver.findElement(By.id("formSeguradoResidencial:cep")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:cep")).sendKeys(getParam("cep"));
		Thread.sleep(3000);
		this.driver.findElement(By.id("formSeguradoResidencial:bairro")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:bairro")).sendKeys(getParam("bairro"));
		this.driver.findElement(By.id("formSeguradoResidencial:logradouro")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:logradouro")).sendKeys(getParam("logradouro"));
		this.driver.findElement(By.id("formSeguradoResidencial:numeroResidencia")).clear();
		this.driver.findElement(By.id("formSeguradoResidencial:numeroResidencia")).sendKeys(getParam("numero"));
		this.driver.findElement(By.id("formSeguradoResidencial:btoProximo321")).click();		
		this.driver.findElement(By.id("formSeguradoResidencial:btoProximo321")).click();
		
		// SEGURO
		Thread.sleep(2000);
		capturarTela();
		this.driver.findElement(By.id("formSeguroPropostaResidencial:btoProximo321")).click();
		
		// COMPLEMENTO DE RISCO
		Thread.sleep(2000);
		capturarTela();		
		selecionarRadioIdDinamico("formComplementoRisco:selectTipoPessoa:1", 1);		
		
		this.driver.findElement(By.id("formComplementoRisco:cep")).clear();
		this.driver.findElement(By.id("formComplementoRisco:cep")).sendKeys(getParam("cepseguro"));
		Thread.sleep(2000);
		this.driver.findElement(By.id("formComplementoRisco:bairro")).clear();
		this.driver.findElement(By.id("formComplementoRisco:bairro")).sendKeys(getParam("bairro"));
		this.driver.findElement(By.id("formComplementoRisco:logradouro")).clear();
		this.driver.findElement(By.id("formComplementoRisco:logradouro")).sendKeys(getParam("logradouro"));
		this.driver.findElement(By.id("formComplementoRisco:numeroResidencia")).clear();
		this.driver.findElement(By.id("formComplementoRisco:numeroResidencia")).sendKeys(getParam("numero"));		
		this.driver.findElement(By.id("formComplementoRisco:btoProximo321")).click();
				
		// EFETIVACAO		
		Thread.sleep(2000);
		capturarTela();
		selecionarDropDown("formEfetivacaoResidencial:formaPagamentoCorretor", 1);
		selecionarDropDown("formEfetivacaoResidencial:qtdeParcelas", 1);
		selecionarDropDown("formEfetivacaoResidencial:diaPreferencial", 29);
		this.driver.findElement(By.id("formEfetivacaoResidencial:btoEfetivarProposta")).click();

		Thread.sleep(2000);
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
