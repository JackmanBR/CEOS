package CEOS.E.RECEBIMENTO_SELENIDE;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import Pages.RecebimentoCompleto;

public class runnerGuerra {
	
	@BeforeClass
	
	void Start() {
		
		Configuration.headless = false;		
		//Configuration.timeout = 7000;
		Configuration.startMaximized = true;
		
	}	
	
	@Test
	public void RecebimentoCompleto() {
		
		Pages.RecebimentoCompleto recebimentoCompleto = new RecebimentoCompleto();
		recebimentoCompleto.CadastraRecebimento();
		
	}

}