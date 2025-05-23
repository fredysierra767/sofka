package co.com.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.opencart.pages.PaginaPrincipalPage.*;

/**
 * Tarea que representa la búsqueda y adición de un producto al carrito desde la página principal.
 *
 * Esta clase implementa la interfaz {@link Task} de Serenity Screenplay.
 * El actor realiza los pasos de buscar el producto, hacer clic en buscar y agregarlo al carrito.
 */
public class BuscarProductos implements Task {

    private final String productoBuscado;

    /**
     * Constructor que recibe el nombre del producto a buscar.
     *
     * @param productoBuscado Nombre del producto que se desea buscar y agregar.
     */
    public BuscarProductos(String productoBuscado) {
        this.productoBuscado = productoBuscado;
    }

    /**
     * Método estático para facilitar la creación de la tarea usando el nombre del producto.
     *
     * @param productoBuscado Nombre del producto a buscar.
     * @return una instancia de la tarea BuscarProductos configurada con el producto dado.
     */
    public static Performable enPaginaPrincipal(String productoBuscado){
        return Tasks.instrumented(BuscarProductos.class, productoBuscado);
    }

    /**
     * Define los pasos que el actor debe realizar para buscar y agregar el producto al carrito.
     *
     * @param actor Actor que realizará la tarea.
     * @param <T> Tipo del actor que extiende de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUSCADOR_DE_PRODUCTOS),
                Enter.theValue(productoBuscado).into(BUSCADOR_DE_PRODUCTOS),
                Click.on(BOTON_BUSCAR),
                Click.on(BOTON_ADICIONAR_AL_CARRITO)
        );
    }
}
