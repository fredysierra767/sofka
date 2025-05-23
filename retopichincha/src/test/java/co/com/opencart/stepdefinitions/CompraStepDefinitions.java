package co.com.opencart.stepdefinitions;

import co.com.opencart.models.FormularioInvitadoModel;
import co.com.opencart.tasks.BuscarProductos;
import co.com.opencart.tasks.IngresarInformacionDeCompra;
import co.com.opencart.tasks.VisualizarCarritoDeCompras;
import co.com.opencart.utils.SetUp;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import java.io.IOException;

import static co.com.opencart.pages.PaginaFinalizacionDeCompra.TEXTO_MENSAJE_CONFIRMACION_ORDEN;
import static co.com.opencart.questions.MensajeOrdenCompleta.mostradoEn;
import static co.com.opencart.utils.Accesos.URL_OPENCART;
import static co.com.opencart.utils.Diccionario.FORMULARIO_CLIENTES;
import static co.com.opencart.utils.UtilsCSV.obtenerDatosPrueba;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

/**
 * Definición de los pasos (step definitions) para el flujo de compra como invitado en OpenCart.
 *
 * Esta clase extiende {@link SetUp} para reutilizar la configuración del WebDriver y Actor.
 * Usa Serenity Screenplay para modelar las interacciones del usuario.
 */
public class CompraStepDefinitions extends SetUp {

    private FormularioInvitadoModel formularioInvitadoModel;

    /**
     * Setup inicial para la ejecución de pruebas:
     * - Configura el entorno general.
     * - Inicializa el escenario Screenplay con un "cast" vacío.
     * - Crea un actor llamado "usuario" con la habilidad de navegar en la web.
     */
    @Before()
    public void setup() {
        setupGeneral();
        OnStage.setTheStage(new Cast());
        OnStage.theActorCalled("usuario").can(BrowseTheWeb.with(webdriver));
    }

    /**
     * Paso dado donde el usuario abre la página principal de OpenCart.
     */
    @Dado("que el usuario abre la página de inicio")
    public void queElUsuarioAbreLaPáginaDeInicio() {
        theActorInTheSpotlight().attemptsTo(Open.url(URL_OPENCART));
    }

    /**
     * Paso cuando el usuario agrega dos productos al carrito desde la página principal.
     *
     * @param productoUno Nombre del primer producto.
     * @param productoDos Nombre del segundo producto.
     */
    @Cuando("agrega los productos {string} y {string} al carrito")
    public void agregaLosProductosYAlCarrito(String productoUno, String productoDos) {
        theActorInTheSpotlight().attemptsTo(
                BuscarProductos.enPaginaPrincipal(productoUno),
                BuscarProductos.enPaginaPrincipal(productoDos)
        );
    }

    /**
     * Paso cuando el usuario visualiza el carrito de compras.
     */
    @Cuando("visualiza el carrito de compras")
    public void visualizaElCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(VisualizarCarritoDeCompras.ingresarAlCarrito());
    }

    /**
     * Paso cuando el usuario completa el checkout como invitado con datos correctos.
     *
     * @param tipoCliente Tipo de cliente (ej. "invitado") para cargar datos de prueba correspondientes.
     * @throws IOException si ocurre error al obtener datos desde CSV.
     */
    @Cuando("completa el checkout como {string} con los datos correctos")
    public void completaElCheckoutComoInvitadoConLosDatosCorrectos(String tipoCliente) throws IOException {
        formularioInvitadoModel = new FormularioInvitadoModel(
                obtenerDatosPrueba(FORMULARIO_CLIENTES, tipoCliente));
        theActorInTheSpotlight().attemptsTo(
                IngresarInformacionDeCompra.enElCarrito(formularioInvitadoModel.getListaFormularioInvitadoModel())
        );
    }

    /**
     * Paso entonces para verificar que el mensaje esperado sea mostrado en pantalla.
     *
     * @param mensajeEsperado Mensaje que debe mostrarse (ej. "Your order has been placed!").
     */
    @Entonces("debería ver el mensaje {string}")
    public void deberíaVerElMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje mostrado en pantalla",
                        mostradoEn(TEXTO_MENSAJE_CONFIRMACION_ORDEN),
                        equalTo(mensajeEsperado)
                )
        );
    }
}
