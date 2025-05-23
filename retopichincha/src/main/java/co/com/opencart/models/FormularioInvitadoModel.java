package co.com.opencart.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class FormularioInvitadoModel {

    private String nombre;
    private String apellido;
    private String email;
    private String nombreEmpresa;
    private String direccionUno;
    private String direccionDos;
    private String nombreCiudad;
    private String numeroTelefono;
    private String nombrePais;
    private String codigoPostal;
    private String nombreDepartamento;
    private String comentario;

    private List<FormularioInvitadoModel> listaFormularioInvitadoModel = new ArrayList<>();

    private FormularioInvitadoModel(Map<String, String> datosFormularioAfiliacion){
        this.nombre = datosFormularioAfiliacion.get("nombre");
        this.apellido = datosFormularioAfiliacion.get("apellido");
        this.email = datosFormularioAfiliacion.get("email");
        this.nombreEmpresa = datosFormularioAfiliacion.get("nombreEmpresa");
        this.direccionUno = datosFormularioAfiliacion.get("direccionUno");
        this.direccionDos = datosFormularioAfiliacion.get("direccionDos");
        this.nombreCiudad= datosFormularioAfiliacion.get("nombreCiudad");
        this.numeroTelefono = datosFormularioAfiliacion.get("numeroTelefono");
        this.nombrePais = datosFormularioAfiliacion.get("nombrePais");
        this.codigoPostal = datosFormularioAfiliacion.get("codigoPostal");
        this.nombreDepartamento = datosFormularioAfiliacion.get("nombreDepartamento");
        this.comentario = datosFormularioAfiliacion.get("comentario");
    }

    public FormularioInvitadoModel(List<Map<String, String>> datosFormulario){
        asignarDatos(datosFormulario);
    }

    private void asignarDatos(List<Map<String, String>> datosFormulario) {
        for (Map<String, String> dato : datosFormulario) {
            listaFormularioInvitadoModel.add(new FormularioInvitadoModel(dato));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getDireccionUno() {
        return direccionUno;
    }

    public String getDireccionDos() {
        return direccionDos;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public String getComentario() {
        return comentario;
    }

    public List<FormularioInvitadoModel> getListaFormularioInvitadoModel() {
        return listaFormularioInvitadoModel;
    }

}
