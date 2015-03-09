package cenarios.accenture.automaisgoldonline;

import static org.junit.Assert.fail;
import helper.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SC001AutoMaisGoldPJ extends TestHelper {
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  	carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.automaisgoldonlinepj";
  }

  @Test
  public void testAutoMaisGoldCNPJ() throws Exception {
	this.driver.get(this.baseUrl + "/cotacao/input.xhtml");
	
	// Input
	preencherCampoTextoSemMascara("formInput:corretor", "input.corretor");
	this.driver.findElement(By.id("formInput:chamar")).click();
    
	// Segurado/Seguro
    esperarElementoCarregado("formSeguroSegurado:cpfCnpj");
    preencherCampoTextoComMascara("formSeguroSegurado:cpfCnpj", "segurado.seguro.cnpj");
    
    this.driver.findElement(By.id("formSeguroSegurado:dddCelular")).click();
	Thread.sleep(3000);
    this.driver.findElement(By.id("formSeguroSegurado:nomeEmpresa")).clear();
    Thread.sleep(3000);
    this.driver.findElement(By.id("formSeguroSegurado:nomeEmpresa")).sendKeys(getParam("segurado.seguro.nome"));
    
    preencherCampoTextoComMascara("formSeguroSegurado:dddCelular", "segurado.seguro.dddcelular");
    preencherCampoTextoComMascara("formSeguroSegurado:telefoneCelular", "segurado.seguro.celular");
    
    preencherCampoTextoComMascara("formSeguroSegurado:dddResidencial", "segurado.seguro.dddresidencial");    
    preencherCampoTextoComMascara("formSeguroSegurado:telefoneResidencial", "segurado.seguro.residencial");
    
    capturarTela();
    this.driver.findElement(By.id("formSeguroSegurado:btoProximo")).click();
    
    // Veículo 
    esperarElementoCarregado("formVeiculo:chassi");
    preencherCampoTextoSemMascara("formVeiculo:chassi", "veiculo.chassi");
    this.driver.findElement(By.id("formVeiculo:fipeMolicar")).click();
    Thread.sleep(5000);
	selecionarDropDown("formVeiculo:uso", 1);
	Thread.sleep(1000);
	capturarTela();
	this.driver.findElement(By.id("formVeiculo:btoProximo")).click();
	
	// Avaliação do Seguro
	esperarElementoCarregado("formAvaliacaoRisco:btoProximo");
	selecionarRadioIdDinamico("formAvaliacaoRisco:id_1", 0);	
	Thread.sleep(2000);
	escreverInputIdDinamico("formAvaliacaoRisco:id_405",getParam("seguro.cep"));
    selecionarDropDownIdDinamico("formAvaliacaoRisco:id_1328", 10);
    capturarTela();
    this.driver.findElement(By.id("formAvaliacaoRisco:btoProximo")).click();
    
    // Coberturas
    esperarElementoCarregado("formCoberturas:save");
    capturarTela();
    rolarParaBaixo("formCoberturas:save");
    capturarTela();
    this.driver.findElement(By.id("formCoberturas:save")).click();
    
    // Valor do Seguro (Calculo)
    esperarElementoCarregado("frmCalculoCotacao:nomeBancoInput");
    preencherCampoTextoSemMascara("frmCalculoCotacao:nomeBancoInput", "valor.seguro.bancorelacionamento");    
    preencherCampoTextoComMascara("frmCalculoCotacao:codigoComissao", "valor.seguro.operacao");
    capturarTela();
    this.driver.findElement(By.id("frmCalculoCotacao:btnCalcular")).click();
    Thread.sleep(2000);
    rolarParaBaixo("frmCalculoCotacao:btnProposta");
    capturarTela();
    this.driver.findElement(By.id("frmCalculoCotacao:btnProposta")).click();

    // Segurado 
    esperarElementoCarregado("formSegurado:atividade");
    selecionarDropDownIdDinamico("formSegurado:atividade", 5);
    selecionarDropDownIdDinamico("formSegurado:pais", 1);
    preencherCampoTextoComMascara("formSegurado:cep", "seguro.cep");
    Thread.sleep(2000);
    preencherCampoTextoSemMascara("formSegurado:numero", "segurado.numero");
    capturarTela();
    rolarParaBaixo("formSegurado:btnProximo");
    capturarTela();
    this.driver.findElement(By.id("formSegurado:btnProximo")).click(); 
    
    // Seguro
    esperarElementoCarregado("formSeguro:botao");
    capturarTela();
    this.driver.findElement(By.id("formSeguro:botao")).click();
    
    // Veiculo / Condutor
    esperarElementoCarregado("formVeiculo:placa");
    preencherCampoTextoSemMascara("formVeiculo:placa", "veiculo.condutor.placa");
    capturarTela();
    this.driver.findElement(By.id("formVeiculo:botaoProximo")).click();

    // Efetivacao
    esperarElementoCarregado("formEfetivacao:formaPagamento");
    selecionarDropDownIdDinamico("formEfetivacao:formaPagamento", 3);
    selecionarDropDownIdDinamico("formEfetivacao:qtdeParcelas", 1);
    capturarTela();
    rolarParaBaixo("formEfetivacao:btnEfetivar");
    capturarTela();
    this.driver.findElement(By.id("formEfetivacao:btnEfetivar")).click();
    capturarTela();
  }

  @After
  public void tearDown() throws Exception {
	this.driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
