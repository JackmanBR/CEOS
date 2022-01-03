package CEOS.RECEBIMENTO_SELENIDE;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import pages.ExpedicaoCompleta;

public class runnerGuerra {
	
	@BeforeClass
	
	void Start() {
		
		Configuration.headless = false;	
		//Configuration.timeout = 7000;
		Configuration.startMaximized = true;
		
	}	
	
	@Test
	public void ExpedicaoCompleta() {
		
		pages.ExpedicaoCompleta expedicaoCompleta = new ExpedicaoCompleta();
				
		expedicaoCompleta.cadastrarExpedicao();		
		
	}
}
