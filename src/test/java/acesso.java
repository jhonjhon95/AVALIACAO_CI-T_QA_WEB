import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class acesso {

    @Test
    public void  TesteacessoSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe"); //abrindo o navegador / Avaliador observe onde está seu drive
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        // implementando teste
        navegador.get("https://123milhas.com/"); // entra no site
        navegador.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/nav/ul/li[4]")).click(); // Navegar até́ a seção hoteis
        Thread.sleep(2000);
        navegador.findElement(By.xpath("//*[@id=\"txtHotelLocation\"]")).sendKeys("comforthotelmanaus"); // digita o nome do hotel
        Thread.sleep(2000); // aguarda o combobox carregar
        WebElement webElement = navegador.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/form-tabs/div/div/div/div[5]/div/hotel-search-form/form/div[1]/input-typeahead/div/label[2]/div/ul/div[5]/li[2]/a")); // identifica o elemento dentro do combobox
        webElement.sendKeys(Keys.DOWN);
        webElement.sendKeys(Keys.ENTER);

        navegador.findElement(By.xpath("//*[@id=\"checkinDate\"]")).click();
        navegador.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/form-tabs/div/div/div/div[5]/div/hotel-search-form/form/div[2]/div[1]/div/ul/li/div/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/button/span")).click(); // informa a data checkin
        navegador.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/form-tabs/div/div/div/div[5]/div/hotel-search-form/form/div[2]/div[2]/div/ul/li/div/div/table/tbody/tr/td[1]/table/tbody/tr[4]/td[7]/button/span")).click(); // informa a data checkout

        navegador.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/form-tabs/div/div/div/div[5]/div/hotel-search-form/form/div[3]/div/div/select-travel-package/div/div/button")).click();
        navegador.findElement(By.id("btnIdChildAdd-1")).click(); // adiciona duas crianças
        navegador.findElement(By.id("btnIdChildAdd-1")).click();


        Select order = new Select(navegador.findElement(By.id("rooms[0].children.ages[0]"))); // informa a idade da primeira criança
        order.selectByValue("number:9");

        Select order2 = new Select(navegador.findElement(By.id("rooms[0].children.ages[1]"))); // informa a idade da segunda criança
        order2.selectByValue("number:10");

        Thread.sleep(2000);
        navegador.findElement(By.id("travel-package-confirm")).click(); // confirma
        Thread.sleep(1000);
        navegador.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/form-tabs/div/div/div/div[5]/div/hotel-search-form/form/button/span")).click(); // pesquisa os hoteis

    }


}

