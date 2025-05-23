package co.com.opencart.tasks;

import co.com.opencart.interactions.Esperar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.opencart.pages.PaginaPrincipalPage.*;

/**
 * Tarea que representa la acción de visualizar el carrito de compras.
 *
 * El actor espera un momento, hace clic para abrir el visualizador del carrito
 * y luego accede al carrito de compras propiamente dicho.
 */
public class VisualizarCarritoDeCompras implements Task {

    /**
     * Método estático para facilitar la creación de esta tarea.
     *
     * @return una instancia de la tarea VisualizarCarritoDeCompras.
     */
    public static Performable ingresarAlCarrito(){
        return Tasks.instrumented(VisualizarCarritoDeCompras.class);
    }

    /**
     * Define los pasos que el actor debe realizar para ingresar y visualizar el carrito.
     *
     * @param actor Actor que realizará la tarea.
     * @param <T> Tipo del actor que extiende de Actor.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Esperar.unMomento(3),
                Click.on(BOTON_VISUALIZADOR_CARRITO),
                Esperar.unMomento(1),
                Click.on(BOTON_INGRESAR_AL_CARRITO)
        );
    }
}
