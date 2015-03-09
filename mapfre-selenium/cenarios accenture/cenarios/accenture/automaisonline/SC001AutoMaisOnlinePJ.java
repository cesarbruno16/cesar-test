package cenarios.accenture.automaisonline;

import helper.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.fail;

public class SC001AutoMaisOnlinePJ extends TestHelper{
	
	private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  	carregarConfiguracoes();
			this.nomeCenario = "cenario01.accenture.automaisonlinepj";
			setUser("d.oliveira.de.melo");
	  }

	  @Test
	  public void testAutoMaisGoldCNPJ() throws Exception {
		  
		this.driver.get(this.baseUrl + "novo-portal-web/cotacao/input.xhtml");
		preencherCampoTextoSemMascara("formInput:corretor", "input.corretor");
	    capturarTela();
	    this.driver.findElement(By.id("formInput:chamar")).click();
	    
	    //Tela segurado/seguro
	    esperarElementoCarregado("formSeguroSegurado:cpfCnpj");
	    preencherCampoTextoSemMascara("formSeguroSegurado:cpfCnpj", "segurado.seguro.cnpj");
	    this.driver.findElement(By.id("formSeguroSegurado:dddCelular")).click();
	    Thread.sleep(3000);
	    this.driver.findElement(By.id("formSeguroSegurado:nomeEmpresa")).clear();
	    Thread.sleep(5000);
	    this.driver.findElement(By.id("formSeguroSegurado:nomeEmpresa")).sendKeys(getParam("segurado.seguro.nome"));
	    preencherCampoTextoSemMascara("formSeguroSegurado:dddCelular", "segurado.seguro.dddcelular");
	    preencherCampoTextoSemMascara("formSeguroSegurado:telefoneCelular", "segurado.seguro.celular");
	    preencherCampoTextoSemMascara("formSeguroSegurado:dddResidencial", "segurado.seguro.dddresidencial");
	    preencherCampoTextoSemMascara("formSeguroSegurado:telefoneResidencial", "segurado.seguro.residencial");
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

		//Tela avaliacao seguro
		esperarElementoCarregado("formAvaliacaoRisco:btoProximo");
		selecionarRadioIdDinamico("formAvaliacaoRisco:id_1", 0);	
		Thread.sleep(3000);
		escreverInputIdDinamico("formAvaliacaoRisco:id_405",getParam("seguro.cep"));
	    selecionarDropDownIdDinamico("formAvaliacaoRisco:id_1328", 10);
	    selecionarRadioIdDinamico("formAvaliacaoRisco:id_106",0);	    
	    capturarTela();
	    this.driver.findElement(By.id("formAvaliacaoRisco:btoProximo")).click();
	    
	    //Tela cobertura
	    esperarElementoCarregado("formCoberturas:save");
	    capturarTela();
	    rolarParaBaixo("formCoberturas:save");
	    capturarTela();
	    this.driver.findElement(By.id("formCoberturas:save")).click();
	    
	    //Tela valor seguro
	    Thread.sleep(6000);
	    esperarElementoCarregado("frmCalculoCotacao:nomeBancoInput");
	    preencherCampoTextoSemMascara("frmCalculoCotacao:nomeBancoInput", "valor.seguro.bancorelacionamento");
	    preencherCampoTextoSemMascara("frmCalculoCotacao:codigoComissao", "valor.seguro.operacao");
	    this.driver.findElement(By.id("frmCalculoCotacao:btnCalcular")).click();
	    capturarTela();
	    Thread.sleep(4000);
	    rolarParaBaixo("frmCalculoCotacao:btnProposta");
	    capturarTela();
	    this.driver.findElement(By.id("frmCalculoCotacao:btnProposta")).click();
	    
	    //Tela Segurado
	    esperarElementoCarregado("formSegurado:atividade");
	    selecionarDropDownIdDinamico("formSegurado:atividade", 5);
	    selecionarDropDownIdDinamico("formSegurado:pais", 1);
	    preencherCampoTextoSemMascara("formSegurado:cep", "seguro.cep");
	    capturarTela();
	    Thread.sleep(1000);
	    preencherCampoTextoSemMascara("formSegurado:numero", "segurado.numero");
	    rolarParaBaixo("formSegurado:btnProximo");
	    capturarTela();
	    this.driver.findElement(By.id("formSegurado:btnProximo")).click();
	    
	    //Tela seguro
	    esperarElementoCarregado("formSeguro:botao");
	    capturarTela();
	    this.driver.findElement(By.id("formSeguro:botao")).click();
	    
	    //Tela veiculo condutor
	    esperarElementoCarregado("formVeiculo:placa");
	    preencherCampoTextoSemMascara("formVeiculo:placa", "veiculo.condutor.placa");
	    capturarTela();
	    this.driver.findElement(By.id("formVeiculo:botaoProximo")).click();
	    
	    //tela efetivacao
	    esperarElementoCarregado("formEfetivacao:formaPagamento");
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
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

}
