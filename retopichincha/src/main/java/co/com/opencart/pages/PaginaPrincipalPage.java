package co.com.opencart.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipalPage extends PageObject {

    public static final Target BUSCADOR_DE_PRODUCTOS = Target.the("Buscador principal de OpenCart")
            .located(By.xpath("//input[@placeholder='Search']"));

    public static final Target BOTON_BUSCAR = Target.the("Boton para buscar productos")
            .located(By.xpath("//button[@class='btn btn-default btn-lg']"));

    public static final Target BOTON_ADICIONAR_AL_CARRITO = Target.the("Boton adicionar al carrito, en cualquier lugar")
            .located(By.xpath("//span[normalize-space()='Add to Cart']"));

    public static final Target BOTON_VISUALIZADOR_CARRITO = Target.the("Boton para visualizar el carrito")
            .located(By.xpath("//div[@id='cart']"));

    public static final Target BOTON_INGRESAR_AL_CARRITO = Target.the("Boton para ingresar el carrito")
            .located(By.xpath("//strong[normalize-space()='View Cart']"));
}
