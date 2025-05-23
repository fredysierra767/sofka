package co.com.opencart.tasks;

import co.com.opencart.interactions.Esperar;
import co.com.opencart.models.FormularioInvitadoModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import java.util.List;

import static co.com.opencart.pages.CarritoDeComprasPage.*;

/**
 * Tarea que permite al actor ingresar la información necesaria para completar
 * el proceso de compra como invitado en el carrito de compras.
 * Recibe una lista con datos del formulario, usualmente con un solo elemento.
 */
public class IngresarInformacionDeCompra implements Task {

    private final List<FormularioInvitadoModel> formularioInvitadoModelList;

    public IngresarInformacionDeCompra(List<FormularioInvitadoModel> formularioInvitadoModelList){
        this.formularioInvitadoModelList = formularioInvitadoModelList;
    }

    /**
     * Método estático para crear la tarea con los datos del formulario.
     *
     * @param formularioInvitadoModelList lista con datos para completar el formulario
     * @return Performable que representa esta tarea
     */
    public static Performable enElCarrito(List<FormularioInvitadoModel> formularioInvitadoModelList){
        return Tasks.instrumented(IngresarInformacionDeCompra.class, formularioInvitadoModelList);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Paso 2: Seleccionar checkout como invitado y continuar
        actor.attemptsTo(
                Esperar.unMomento(1),
                Scroll.to(BOTON_CHECKOUT),
                Click.on(BOTON_CHECKOUT),
                Click.on(RADIO_BOTON_INVITADO),
                Click.on(BOTON_CONTINUAR)
        );

        // Ingresar datos personales y de dirección del invitado
        actor.attemptsTo(
                Esperar.unMomento(1),
                Enter.theValue(formularioInvitadoModelList.get(0).getNombre()).into(IMPUT_NOMBRE),
                Enter.theValue(formularioInvitadoModelList.get(0).getApellido()).into(IMPUT_APELLIDO),
                Enter.theValue(formularioInvitadoModelList.get(0).getEmail()).into(IMPUT_EMAIL),
                Enter.theValue(formularioInvitadoModelList.get(0).getNumeroTelefono()).into(IMPUT_TELEFONO),
                Enter.theValue(formularioInvitadoModelList.get(0).getNombreEmpresa()).into(IMPUT_EMPRESA),
                Enter.theValue(formularioInvitadoModelList.get(0).getDireccionUno()).into(IMPUT_DIRECCION_UNO),
                Enter.theValue(formularioInvitadoModelList.get(0).getDireccionDos()).into(IMPUT_DIRECCION_DOS),
                Enter.theValue(formularioInvitadoModelList.get(0).getNombreCiudad()).into(IMPUT_CIUDAD),
                Enter.theValue(formularioInvitadoModelList.get(0).getCodigoPostal()).into(IMPUT_CODIGO_POSTAL),
                Esperar.unMomento(1),
                SelectFromOptions.byVisibleText(formularioInvitadoModelList.get(0).getNombrePais()).from(IMPUT_PAIS),
                Esperar.unMomento(1),
                Scroll.to(IMPUT_DEPARTAMENTO),
                SelectFromOptions.byVisibleText(formularioInvitadoModelList.get(0).getNombreDepartamento()).from(IMPUT_DEPARTAMENTO),
                Click.on(BOTON_CONTINUAR_PASO_2)
        );

        // Paso 4: Ingresar comentarios
        actor.attemptsTo(
                Esperar.unMomento(1),
                Enter.theValue(formularioInvitadoModelList.get(0).getComentario()).into(IMPUT_COMENTARIOS),
                Click.on(BOTON_CONTINUAR_PASO_4)
        );

        // Paso 5: Aceptar términos y continuar
        actor.attemptsTo(
                Esperar.unMomento(1),
                Click.on(CHECK_TERMINOS_CONDICIONES),
                Click.on(BOTON_CONTINUAR_PASO_5)
        );

        // Confirmar orden en paso final
        Esperar.unMomento(2);
        actor.attemptsTo(Click.on(BOTON_CONTINUAR_PASO_6));
    }

}
