package co.com.opencart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Question personalizada de Screenplay que permite verificar
 * si el mensaje de confirmación de una orden ("Your order has been placed!")
 * es visible en la página de finalización de compra.
 *
 * Esta clase aplica una espera explícita hasta que el elemento esté visible
 * antes de obtener su texto.
 */
public class MensajeOrdenCompleta implements Question<String> {

    private final Target mensaje;

    private MensajeOrdenCompleta(Target mensaje) {
        this.mensaje = mensaje;
    }

    public static MensajeOrdenCompleta mostradoEn(Target mensaje) {
        return new MensajeOrdenCompleta(mensaje);
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(mensaje, isVisible()).forNoMoreThan(10).seconds()
        );

        return mensaje.resolveFor(actor).getText().trim();
    }
}
