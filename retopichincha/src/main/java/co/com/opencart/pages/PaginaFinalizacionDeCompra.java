package co.com.opencart.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaFinalizacionDeCompra {

    //Mensaje confirmacion de compra
    public static final Target TEXTO_MENSAJE_CONFIRMACION_ORDEN = Target.the("Texto de confirmacion")
            .located(By.xpath("//h1[normalize-space()='Your order has been placed!']"));

}
