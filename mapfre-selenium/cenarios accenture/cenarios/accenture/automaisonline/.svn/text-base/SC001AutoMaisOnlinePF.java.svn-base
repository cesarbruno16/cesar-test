package cenarios.accenture.automaisonline;

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
public class SC001AutoMaisOnlinePF extends TestHelper {

	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.automaisonlinepf";
	}

	@Test
	public void testSC001Automais() throws Exception {
		this.driver.get(this.baseUrl + "/cotacao/input.xhtml");
		
		//Tela input
		preencherCampoTextoSemMascara("formInput:corretor", "input.corretor");
		capturarTela();
		this.driver.findElement(By.id("formInput:chamar")).click();
		
		//Tela segurado/seguro
		esperarElementoCarregado("formSeguroSegurado:cpfCnpj");
		preencherCampoTextoComMascara("formSeguroSegurado:cpfCnpj", "segurado.seguro.cpf");
		Thread.sleep(3000);
		this.driver.findElement(By.id("formSeguroSegurado:nomeProponente")).clear();
		Thread.sleep(5000);
		preencherCampoTextoSemMascara("formSeguroSegurado:nomeProponente","segurado.seguro.nome");
		preencherCampoTextoComMascara("formSeguroSegurado:dataNascimento", "segurado.seguro.datanascimento");
		preencherCampoTextoSemMascara("formSeguroSegurado:dddCelular","segurado.seguro.dddcelular");
		preencherCampoTextoSemMascara("formSeguroSegurado:telefoneCelular", "segurado.seguro.celular");
		preencherCampoTextoSemMascara("formSeguroSegurado:dddResidencial","segurado.seguro.dddresidencial");
		preencherCampoTextoSemMascara("formSeguroSegurado:telefoneResidencial","segurado.seguro.residencial");
		capturarTela();
		this.driver.findElement(By.id("formSeguroSegurado:btoProximo")).click();
		
		//Tela veiculo
		esperarElementoCarregado("formVeiculo:chassi");
		preencherCampoTextoSemMascara("formVeiculo:chassi", "veiculo.chassi");
		this.driver.findElement(By.id("formVeiculo:fipeMolicar")).click();
	    Thread.sleep(5000);
		selecionarDropDown("formVeiculo:uso", 1);
		Thread.sleep(1000);
		capturarTela();
		this.driver.findElement(By.id("formVeiculo:btoProximo")).click();
		
		//Tela avaliacvao seguro
		esperarElementoCarregado("formAvaliacaoRisco:btoProximo");
		selecionarRadioIdDinamico("formAvaliacaoRisco:id_2936", 1);	
		Thread.sleep(3000);
		selecionarRadioIdDinamico("formAvaliacaoRisco:id_98", 1);
		selecionarDropDownIdDinamico("formAvaliacaoRisco:id_100", 4);
		selecionarDropDownIdDinamico("formAvaliacaoRisco:id_240", 4);
		selecionarDropDownIdDinamico("formAvaliacaoRisco:id_395", 2);
		selecionarDropDownIdDinamico("formAvaliacaoRisco:id_285", 4);
		selecionarRadioIdDinamico("formAvaliacaoRisco:id_396", 1);
	    selecionarRadioIdDinamico("formAvaliacaoRisco:id_397", 1);
	    selecionarDropDownIdDinamico("formAvaliacaoRisco:id_105", 2);
	    capturarTela();
	    rolarParaBaixo("formAvaliacaoRisco:btoProximo");
	    escreverInputIdDinamico("formAvaliacaoRisco:id_405",getParam("seguro.cep"));
	    selecionarDropDownIdDinamico("formAvaliacaoRisco:id_1328", 10);
	    selecionarRadioIdDinamico("formAvaliacaoRisco:id_398", 0);
	    selecionarRadioIdDinamico("formAvaliacaoRisco:id_106", 0);
	    selecionarRadioIdDinamico("formAvaliacaoRisco:id_400", 0);
	    selecionarRadioIdDinamico("formAvaliacaoRisco:id_1327", 0);
	    capturarTela();
	    this.driver.findElement(By.id("formAvaliacaoRisco:btoProximo")).click();
	    
	    //Tela cobertura
	    Thread.sleep(5000);
	    capturarTela();
	    rolarParaBaixo("formCoberturas:save");
	    capturarTela();
	    this.driver.findElement(By.id("formCoberturas:save")).click();
	    
	    //Tela valor seguro
		esperarElementoCarregado("frmCalculoCotacao:nomeBancoInput");
		preencherCampoTextoSemMascara("frmCalculoCotacao:nomeBancoInput","valor.seguro.bancorelacionamento");
		preencherCampoTextoSemMascara("frmCalculoCotacao:codigoComissao","valor.seguro.operacao");
	    this.driver.findElement(By.id("frmCalculoCotacao:btnCalcular")).click();
	    capturarTela();
	    Thread.sleep(4000);
	    rolarParaBaixo("frmCalculoCotacao:btnProposta");
	    capturarTela();
	    this.driver.findElement(By.id("frmCalculoCotacao:btnProposta")).click();
	    
	    //Tela Segurado
	    esperarElementoCarregado("formSegurado:documento");
	    selecionarDropDownIdDinamico("formSegurado:rendaMensal", 1);
	    selecionarDropDownIdDinamico("formSegurado:pais", 1);
	    selecionarDropDownIdDinamico("formSegurado:tipoDocumento", 5); 
	    preencherCampoTextoSemMascara("formSegurado:documento","segurado.numerodocumento");
	    selecionarDropDownIdDinamico("formSegurado:orgaoExpedidor", 21);
	    preencherCampoTextoComMascara("formSegurado:dtExpedicao","segurado.dataexpedicao");
	    preencherCampoTextoComMascara("formSegurado:cep","seguro.cep");
	    capturarTela();
	    Thread.sleep(1000);
	    preencherCampoTextoSemMascara("formSegurado:numero","segurado.numero");
	    rolarParaBaixo("formSegurado:btnProximo");
	    capturarTela();
	    this.driver.findElement(By.id("formSegurado:btnProximo")).click();
	    
	    //Tela seguro
	    esperarElementoCarregado("formSeguro:botao");
	    capturarTela();
	    this.driver.findElement(By.id("formSeguro:botao")).click();
	    
	    //Tela veiculo condutor
	    esperarElementoCarregado("formVeiculo:placa");
	    preencherCampoTextoSemMascara("formVeiculo:placa","veiculo.condutor.placa");
	    capturarTela();
	    this.driver.findElement(By.id("formVeiculo:botaoProximo")).click();
	    
	    //tela efetivacao
	    esperarElementoCarregado("formEfetivacao:btnEfetivar");
	    selecionarDropDownIdDinamico("formEfetivacao:formaPagamento", 3);
	    selecionarDropDownIdDinamico("formEfetivacao:qtdeParcelas", 1);
	    capturarTela();
	    rolarParaBaixo("formEfetivacao:btnEfetivar");
	    this.driver.findElement(By.id("formEfetivacao:btnEfetivar")).click();
	    Thread.sleep(4000);
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
