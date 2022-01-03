package pages;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import java.io.File;

import org.openqa.selenium.By;

import Utils.Utils;

public class ExpedicaoCompleta {
	
	public void cadastrarExpedicao() {
		
		Utils util = new Utils();
		
		//ABRIR NAVEGADOR, ACESSAR E LOGAR NO AMBIENTE CEOS
		System.out.println("Acessando ambiente...");

		open("http://integra.ceos.alclog.com.br:8090/public/login/login");
		$("#userLogin").setValue("jpguerra");
		$("#userPassword").setValue("1a2b3c");
		$("#buttonLogin").click();
		
		//ACESSAR CADASTRO REQUISIÇÃO
		System.out.println("Acessando cadastro de requisição...");
		
		$(By.xpath("//*[@id=\"dynamicmenu\"]/ul/li[10]/a/span[1]")).hover();
		$(By.cssSelector("#dynamicmenu > ul > li.ui-widget.ui-menuitem.ui-corner-all.ui-menu-parent.ui-menuitem-active > ul > li:nth-child(3) > a > span.ui-menuitem-text")).hover();
		$(By.cssSelector("#menuitem292 > span")).hover().click();
		
		//PREENCHER CAMPOS REQUISICAO
		System.out.println("Preenchendo abas e campos da requisição...");
		sleep(1000);
		$(By.name("tabViewRequisition:requisitionStockLevel:requisitionStockLevel_identifier")).setValue("100").pressEnter();
		sleep(4000);
		$(By.name("tabViewRequisition:requisitionRequesterUnit:requisitionRequesterUnit_identifier")).setValue("9525").pressEnter();
		sleep(4000);
		$(By.name("tabViewRequisition:requisitionMovement:requisitionMovement_identifier")).setValue("8").pressEnter();
		sleep(3000);
		$(By.cssSelector("#tabViewRequisition\\:requisitionDesiredDeliveryDate\\:requisitionDesiredDeliveryDate_inputGroup > button > span.ui-button-icon-left.ui-icon.ui-icon-calendar")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month > option:nth-child(1)")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year > option:nth-child(11)")).click();
		$(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(6) > td:nth-child(1) > a")).click();
		$(By.cssSelector("#tabViewRequisition\\:requisitionPeriodicity_label")).click();
		sleep(1000);		
		$(By.cssSelector("#tabViewRequisition\\:requisitionPeriodicity_panel > div > ul > li:nth-child(2)")).click();
		sleep(1000);
		$(By.cssSelector("#tabViewRequisition\\:requisitionLawsuit_label")).click();
		$(By.cssSelector("#tabViewRequisition\\:requisitionLawsuit_panel > div > ul > li:nth-child(2)")).click();
		$(By.name("tabViewRequisition:requisitionObservation")).setValue("teste automação!");
		
		$(By.cssSelector("#tabViewRequisition > ul > li:nth-child(2) > a")).click();
				
		$(By.cssSelector("#tabViewRequisition\\:j_idt98 > span")).click();
		sleep(4000);
		$(By.name("tabViewRequisition:requisition_ItemsTable:0:requisitionItemProduct:requisitionItemProduct_identifier")).setValue("3256707.1").pressEnter();
		sleep(4000);
		$(By.cssSelector("#tabViewRequisition\\:requisition_ItemsTable\\:0\\:requisitionItemUnitMeasurement_label")).click();
		$(By.cssSelector("#tabViewRequisition\\:requisition_ItemsTable\\:0\\:requisitionItemUnitMeasurement_panel > div > ul > li:nth-child(2)")).click();
		$(By.name("tabViewRequisition:requisition_ItemsTable:0:j_idt118")).setValue("1");
		
		$(By.cssSelector("#tabViewRequisition > ul > li:nth-child(3) > a")).click();
		File file = $(By.name("tabViewRequisition:requisitionDocument_input")).uploadFile(new File("src/documents/teste.pdf"));
		file.exists();
		sleep(2000);	
		$(By.name("tabViewRequisition:requisitionDocumentDescription")).setValue("teste automação.");
		$("#finalizeRegistrationLink").click();
		sleep(1000);
		$(By.cssSelector("#j_idt289\\:j_idt291")).click();
		sleep(1000);
		
				
		System.out.println("Cadastro de requisição realizado com sucesso sob o número abaixo: ");
		util.capturarString();
		System.out.println("requisição capturada e pronta para ser inserida na expedição...");
		sleep(1000);
		
		//ACESSAR CADASTRO DE EXPEDIÇÃO
		System.out.println("Acessando cadastro de expedição...");
		
		$(By.xpath("//*[@id=\"dynamicmenu\"]/ul/li[10]/a/span[1]")).hover();
		$(By.cssSelector("#dynamicmenu > ul > li.ui-widget.ui-menuitem.ui-corner-all.ui-menu-parent.ui-menuitem-active > ul > li:nth-child(2) > a > span.ui-menuitem-text")).hover();
		$(By.cssSelector("#menuitem392 > span")).hover().click();
		
		//PREENCHE CAMPOS EXPEDIÇÃO
		System.out.println("Preenchendo abas e campos da expedição...");
		
		$(By.name("tabViewExpedition:expeditionRequisition:expeditionRequisition_identifier")).setValue(util.numeros).pressEnter();
		sleep(1000);
		$(By.name("tabViewExpedition:expeditionSupplierUnit:expeditionSupplierUnit_identifier")).setValue("7").pressEnter();
		sleep(1000);
		$(By.cssSelector("#tabViewExpedition\\:expeditionTransportingResponsible_label")).click();
		sleep(500);
		
		
		$(By.cssSelector("#tabViewExpedition\\:expeditionTransportingResponsible_panel > div > ul > li:nth-child(3)")).click();
		sleep(1000);
		
		//PREVISÃO-ENTREGA
		$(By.cssSelector("#tabViewExpedition\\:expedtionAgreedDeliveryForecast > button > span.ui-button-icon-left.ui-icon.ui-icon-calendar")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month > option:nth-child(1)")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year")).click();
		$(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year > option:nth-child(51)")).click();
		$(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(6) > td:nth-child(1) > a")).click();		
		
		
		$(By.name("tabViewExpedition:expeditionObservation")).setValue("teste automação");
		sleep(1000);
		$(By.cssSelector("#tabViewExpedition > ul > li:nth-child(2) > a")).click();
		sleep(1000);
		$(By.cssSelector("#tabViewExpedition > ul > li:nth-child(3) > a")).click();
		File file2 = $(By.name("tabViewExpedition:expeditionDocument_input")).uploadFile(new File("src/documents/teste.pdf"));
		file2.exists();
		sleep(1000);		
		$(By.name("tabViewExpedition:expeditionDocumentDescription")).setValue("Teste automação!");
		$("#saveExpeditionLink").click();
		
		System.out.println("Cadastro de expedição realizado com sucesso!");
		sleep(2000);
				
	}
}
