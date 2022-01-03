package Utils;

import static com.codeborne.selenide.Selenide.$;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public String numeros;
	public String numeros2;

	public static WebDriver driver;

	// wait de espera implicita
	public void esperarElemento(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void waitElementBePresent(By element, Integer tempo) {
		WebDriverWait wait = new WebDriverWait(driver, tempo);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public String getRandomEmail() {

		String email_init = "jp_";
		String email_final = "@jp.com.br";

		Random random = new Random();
		int minimo = 1;
		int maximo = 99999999;
		int resultado = random.nextInt(maximo - minimo) + minimo;

		return email_init + resultado + email_final;

	}

	// GERADOR DE INT
	public int GetIntRandom() {

		Random random = new Random();
		int minimo = 11111;
		int maximo = 99999;
		int resultado = random.nextInt(maximo - minimo) + minimo;

		return resultado;
	}

	// GERADOR DE STRING
	public String GetStringRandom() {

		Random random = new Random();
		int minimo = 11111;
		int maximo = 99999;
		int resultado = random.nextInt(maximo - minimo) + minimo;

		// Integer.toString(resultado);
		// String.valueOf(resultado);
		String res = Integer.toString(resultado);

		return res;
	}

	public String capturarString() {

		String texto = $(By.cssSelector("#ceosGeneralMessages > div > ul > li > span")).getText();
		numeros = texto.replaceAll("[^0-9]", "");

		System.out.println(numeros);
		return numeros;

	}
	
	public String capturarString2() {

		String texto = $(By.cssSelector("#ceosGeneralMessages > div > ul > li > span")).getText();
		numeros2 = texto.replaceAll("[^0-9]", "");

		System.out.println(numeros2);
		return numeros;

	}

	public void RolarTela() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, 10000");
		Thread.sleep(2000);
	}

	public void waitElement(By element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
