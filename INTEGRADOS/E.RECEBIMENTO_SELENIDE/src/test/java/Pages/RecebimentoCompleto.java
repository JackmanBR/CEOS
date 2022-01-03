package Pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import java.io.File;

import org.openqa.selenium.By;

import Utils.Utils;

public class RecebimentoCompleto {
	
	public void CadastraRecebimento() {
		
		Utils util = new Utils();
		
		//ABRIR NAVEGADOR, LOGAR E ACESSAR O AMBIENTE
		System.out.println("Acessando ambiente...");

		open("http://integra.ceos.alclog.com.br:8090/public/login/login");

		$("#userLogin").setValue("jpguerra");
		$("#userPassword").setValue("1a2b3c");
		$("#buttonLogin").click();
		
		//ACESSANDO CADASTRO DE FORNECIMENTO
		System.out.println("Acessando cadastro de ordem de fornecimento...");
		
		$(By.xpath("//*[@id=\"dynamicmenu\"]/ul/li[6]/a/span[1]")).hover();
		$(By.cssSelector("#dynamicmenu > ul > li.ui-widget.ui-menuitem.ui-corner-all.ui-menu-parent.ui-menuitem-active > ul > li:nth-child(4) > a > span.ui-menuitem-text")).hover();
		$(By.cssSelector("#menuitem188 > span")).hover().click();	
		
		//PREENCHENDO ORDEM DE FORNECIMENTO
		System.out.println("Preenchendo abas e campos da ordem de fornecimento...");
		
		$(By.name("tabViewDeliveryOrder:deliveryOrderStockLevel:deliveryOrderStockLevel_identifier")).setValue("100").pressEnter();
		sleep(1000);
		$(By.name("tabViewDeliveryOrder:deliveryOrderNumber")).setValue(util.GetStringRandom()).pressEnter();
		sleep(1000);
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrderDateReceiptSupplier > button > span.ui-button-icon-left.ui-icon.ui-icon-calendar")).click();
		$(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(6) > a")).click();
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrderDateIssuance > button > span.ui-button-icon-left.ui-icon.ui-icon-calendar")).click();
		$(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(6) > a")).click();
		$(By.name("tabViewDeliveryOrder:deliveryOrderPreviousExerciseJustification")).setValue("teste automação, campo justificativa!");
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrderLawsuit_label")).click();
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrderLawsuit_panel > div > ul > li:nth-child(2)")).click();
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrderModality_label")).click();
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrderModality_panel > div > ul > li:nth-child(2)")).click();
		$(By.name("tabViewDeliveryOrder:deliveryOrderSupplier:deliveryOrderSupplier_identifier")).setValue("7").pressEnter();
		sleep(1000);
		$(By.name("tabViewDeliveryOrder:deliveryOrderManagementUnit:deliveryOrderManagementUnit_identifier")).setValue("530410").pressEnter();
		sleep(1000);
		$(By.name("tabViewDeliveryOrder:deliveryOrderFundingSource:deliveryOrderFundingSource_identifier")).setValue("0020800000").pressEnter();
		sleep(2000);
		$(By.name("tabViewDeliveryOrder:deliveryOrderMovement:deliveryOrderMovement_identifier")).setValue("2").pressEnter();
		sleep(2000);
		$(By.name("tabViewDeliveryOrder:deliveryOrderObservation")).setValue("teste automação, campo observação!");
		sleep(2000);
		
		$(By.cssSelector("#tabViewDeliveryOrder > ul > li:nth-child(2) > a")).click();
		$(By.cssSelector("#tabViewDeliveryOrder\\:j_idt160 > span")).click();
		sleep(2000);
		$(By.name("tabViewDeliveryOrder:deliveryOrder_ItemsTable:0:deliveryOrderItemProduct:deliveryOrderItemProduct_identifier")).setValue("3256707.1").pressEnter();
		sleep(2000);
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrder_ItemsTable\\:0\\:deliveryOrderItemUnitMeasurement_label")).click();
		sleep(2000);
		$(By.cssSelector("#tabViewDeliveryOrder\\:deliveryOrder_ItemsTable\\:0\\:deliveryOrderItemUnitMeasurement_panel > div > ul > li:nth-child(3)")).click();
		$(By.name("tabViewDeliveryOrder:deliveryOrder_ItemsTable:0:deliveryOrderItemAvailableQuantity")).setValue("50").pressEnter();	
		$(By.name("tabViewDeliveryOrder:deliveryOrder_ItemsTable:0:deliveryOrderItemUnitValue")).setValue("1").pressEnter();
		$(By.name("tabViewDeliveryOrder:deliveryOrderTotalValue")).setValue("50").pressEnter();
		sleep(1000);
		
		$(By.cssSelector("#tabViewDeliveryOrder > ul > li:nth-child(3) > a")).click();
		$(By.name("tabViewDeliveryOrder:deliveryOrderDeliveryModel:deliveryOrderDeliveryModel_identifier")).setValue("17").pressEnter();
		sleep(1000);
		$(By.name("tabViewDeliveryOrder:deliveryOrderDeliveryObservation")).setValue("teste automação, campo observação de entrega!");
		sleep(500);
		
		$(By.cssSelector("#tabViewDeliveryOrder > ul > li:nth-child(4) > a")).click();
		File file = $(By.name("tabViewDeliveryOrder:deliveryOrderDocument_input")).uploadFile(new File("src/documents/teste.pdf"));
		file.exists();
		sleep(2000);
		$(By.name("tabViewDeliveryOrder:deliveryOrderDocumentDescription")).setValue("teste automação, campo descrição!");
		$(By.cssSelector("#finalizeRegistrationLink")).click();
		sleep(5000);
						
		System.out.println("Cadastro de ordem de fornecimento realizado com sucesso sob o número abaixo: ");
		util.capturarString();
		System.out.println("ordem de fornecimento capturada e pronta para ser inserida no documento de recebimento...");
		sleep(1000);
		
		//ACESSAR CADASTRO DE DOCUMENTO DE RECEBIMENTO
		System.out.println("Acessando cadastro de documento de recebimento...");
		
		$(By.xpath("//*[@id=\"dynamicmenu\"]/ul/li[8]/a/span[1]")).hover();
		$(By.cssSelector("#dynamicmenu > ul > li.ui-widget.ui-menuitem.ui-corner-all.ui-menu-parent.ui-menuitem-active > ul > li:nth-child(2) > a > span.ui-menuitem-text")).hover();
		$(By.cssSelector("#menuitem311 > span")).hover().click();
		
		//PREENCHENDO ORDEM DE FORNECIMENTO
		System.out.println("Preenchendo dados...");
		
		$(By.name("tabViewReceptionDocument:receptionDocumentDeliveryOrder:receptionDocumentDeliveryOrder_identifier")).setValue(util.numeros).pressEnter();
		sleep(2000);		
		$(By.name("tabViewReceptionDocument:receptionDocumentReceivingUnit:receptionDocumentReceivingUnit_identifier")).setValue("7").pressEnter();
		sleep(2000);
		$(By.cssSelector("#tabViewReceptionDocument\\:receptionDocumentDateIssuance > button > span.ui-button-icon-left.ui-icon.ui-icon-calendar")).click();
		$(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(6) > a")).click();
		$(By.cssSelector("#tabViewReceptionDocument\\:receptionDocumentType_label")).click();
		$(By.cssSelector("#tabViewReceptionDocument\\:receptionDocumentType_panel > div > ul > li:nth-child(2)")).click();
		sleep(2000);
		$(By.name("tabViewReceptionDocument:receptionDocumentFiscalNumber")).setValue(util.GetStringRandom());
		sleep(1000);
		$(By.name("tabViewReceptionDocument:receptionDocumentFiscalSeries")).setValue(util.GetStringRandom());
		sleep(1000);
		$(By.name("tabViewReceptionDocument:receptionDocumentObservation")).setValue("teste automação, campo observação!");
		sleep(1000);
		
		$(By.cssSelector("#tabViewReceptionDocument > ul > li:nth-child(2) > a")).click();
		sleep(500);
		$(By.name("tabViewReceptionDocument:receptionDocumentTotalValue")).setValue("50");
		sleep(500);
		
		$(By.cssSelector("#tabViewReceptionDocument > ul > li:nth-child(3) > a")).click();
		sleep(1000);
		File file2 = $(By.name("tabViewReceptionDocument:receptionDocumentDocument_input")).uploadFile(new File("src/documents/teste.pdf"));
		file2.exists();
		sleep(2000);
		$(By.name("tabViewReceptionDocument:receptionDocumentDocumentDescription")).setValue("teste automação, campo descrição...");
		$(By.cssSelector("#finalizeRegistrationLink")).click();		
		
		System.out.println("Cadastro de documento de recebimento realizado com sucesso sob o número abaixo: ");
		util.capturarString2();
		System.out.println("documento de recebimento capturado e pronto para ser inserida no recebimento...");
		sleep(1000);
		
		//ACESSANDO CADASTRO DE RECEBIMENTO
		System.out.println("Acessando cadastro de recebimento...");
		
		$(By.xpath("//*[@id=\"dynamicmenu\"]/ul/li[8]/a/span[1]")).hover();
		$(By.cssSelector("#dynamicmenu > ul > li.ui-widget.ui-menuitem.ui-corner-all.ui-menu-parent.ui-menuitem-active > ul > li:nth-child(4) > a > span.ui-menuitem-text")).hover();
		$(By.cssSelector("#menuitem321 > span")).hover().click();
		
		//PREENCHENDO ABAS E CAMPOS DO RECEBIMENTO
		System.out.println("Preenchendo abas e campos do recebimento...");
		
		$(By.name("tabViewReception:receptionReceptionDocument:receptionReceptionDocument_identifier")).setValue(util.numeros2).pressEnter();
		sleep(2000);
		$(By.cssSelector("#tabViewReception\\:receptionTypes_label")).click();
		$(By.cssSelector("#tabViewReception\\:receptionTypes_panel > div > ul > li:nth-child(2)")).click();
		$(By.cssSelector("#tabViewReception\\:receptionNecessaryAttest_label")).click();
		$(By.cssSelector("#tabViewReception\\:receptionNecessaryAttest_panel > div > ul > li.ui-selectonemenu-item.ui-selectonemenu-list-item.ui-corner-all.ui-state-active")).click();
		$(By.name("tabViewReception:receptionObservation")).setValue("teste automação, campo observação...");
		sleep(500);
		
		$(By.cssSelector("#tabViewReception > ul > li:nth-child(2) > a")).click();
		sleep(500);
		
		$(By.cssSelector("#tabViewReception > ul > li:nth-child(3) > a")).click();		
		$(By.name("tabViewReception:setVehicleInReception:setVehicleInReception_identifier")).setValue("AAA1111").pressEnter();
		
		$(By.cssSelector("#tabViewReception > ul > li:nth-child(4) > a")).click();
		File file3 = $(By.name("tabViewReception:receptionDocument_input")).uploadFile(new File("src/documents/teste.pdf"));
		file3.exists();
		sleep(2000);
		$(By.cssSelector("#tabViewReception\\:attachonreceivingdocument_label")).click();
		$(By.cssSelector("#tabViewReception\\:attachonreceivingdocument_panel > div > ul > li:nth-child(2)")).click();
		$(By.name("tabViewReception:receptionDocumentDescription")).setValue("teste automação, campo descrição!");
		sleep(500);
		$(By.cssSelector("#insertLink")).click();
		
		System.out.println("Recebimento cadastrado com Sucesso!");	
		
	}	
}
