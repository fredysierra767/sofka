package co.com.opencart.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoDeComprasPage {

    public static final Target BOTON_CHECKOUT = Target.the("Boton Checkout y continuar la compra")
            .located(By.xpath("//a[@class='btn btn-primary']"));

    //Step 1 del checkout de compras
    public static final Target RADIO_BOTON_INVITADO = Target.the("Radio boton seleccionar invitado")
            .located(By.xpath("//input[@value='guest']"));

    public static final Target BOTON_CONTINUAR= Target.the("Boton continuar indicando tipo cliente")
            .located(By.xpath("//input[@id='button-account']"));

    //Step 2 del checkout de compras datos personales
    public static final Target IMPUT_NOMBRE = Target.the("Imput nombre")
            .located(By.id("input-payment-firstname"));

    public static final Target IMPUT_APELLIDO = Target.the("Imput apellido")
            .located(By.id("input-payment-lastname"));

    public static final Target IMPUT_EMAIL = Target.the("Imput email")
            .located(By.id("input-payment-email"));

    public static final Target IMPUT_TELEFONO = Target.the("Imput telefono")
            .located(By.id("input-payment-telephone"));

    public static final Target IMPUT_EMPRESA = Target.the("Imput empresa")
            .located(By.id("input-payment-company"));

    public static final Target IMPUT_DIRECCION_UNO = Target.the("Imput direccion uno")
            .located(By.id("input-payment-address-1"));

    public static final Target IMPUT_DIRECCION_DOS = Target.the("Imput direccion dos")
            .located(By.id("input-payment-address-2"));

    public static final Target IMPUT_CIUDAD = Target.the("Imput ciudad")
            .located(By.id("input-payment-city"));

    public static final Target IMPUT_CODIGO_POSTAL = Target.the("Imput codigo postal")
            .located(By.id("input-payment-postcode"));

    public static final Target IMPUT_PAIS = Target.the("Imput pais")
            .located(By.id("input-payment-country"));

    public static final Target IMPUT_DEPARTAMENTO = Target.the("Imput departamento")
            .located(By.id("input-payment-zone"));

    public static final Target BOTON_CONTINUAR_PASO_2 = Target.the("Boton continuar paso 2")
            .located(By.id("button-guest"));

    //Step 4 del checkout comentarios adicionales en la compra
    public static final Target IMPUT_COMENTARIOS = Target.the("Imput comentarios")
            .located(By.xpath("//textarea[@name='comment']"));

    public static final Target BOTON_CONTINUAR_PASO_4 = Target.the("Boton continuar la compra")
            .located(By.id("button-shipping-method"));

    //Step 5 del checkout metodo de pago
    public static final Target CHECK_TERMINOS_CONDICIONES = Target.the("Terminos y condicones")
            .located(By.xpath("//input[@name='agree']"));

    public static final Target BOTON_CONTINUAR_PASO_5 = Target.the("Boton continuar la compra paso 5")
            .located(By.xpath("//input[@id='button-payment-method']"));

    //Step 6 del checkout confrimar orden
    public static final Target BOTON_CONTINUAR_PASO_6 = Target.the("Boton continuar la compra paso 6")
            .located(By.id("button-confirm"));

}
