package co.com.opencart.enums;

public enum VariablesEnum {

    PRODUCTO_UNO_ELEGIDO("producto1"),

    PRODUCTO_DOS_ELEGIDO("producto2");

    private final String valor;

    VariablesEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
