package co.com.opencart.utils;

import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Clase utilitaria para la lectura y filtrado de datos desde archivos CSV.
 * Utiliza la librería Thucydides (Serenity) para la gestión de fuentes de datos de prueba.
 */
public class UtilsCSV {

    private static final String RUTA_RECURSOS_DATOS_CSV = "data/";
    private static final String PREFIJO_NOMBRE_DATOS_CSV = "datos_";
    private static final String EXTENSION_NOMBRE_DATOS_CSV = ".csv";
    private static final String NOMBRE_COLUMNA_FILTRO = "idFiltro";
    private static final String SEPARADOR_COMA = ",";
    private static final char SEPARADOR_VALORES_CSV = ';';

    // Constructor privado para evitar instanciación
    private UtilsCSV() {}

    /**
     * Obtiene los datos de prueba desde un archivo CSV filtrando por uno o varios valores.
     *
     * @param nombreCSV nombre base del archivo CSV (sin prefijo ni extensión)
     * @param filtro cadena con valores para filtrar (separados por coma),
     *               o vacío para obtener todos los registros
     * @return lista de mapas con los datos filtrados, donde cada mapa representa una fila CSV
     * @throws IOException si hay un problema leyendo el archivo
     * @throws NoSuchElementException si el filtro no produce resultados
     */
    public static List<Map<String, String>> obtenerDatosPrueba(String nombreCSV, String filtro)
            throws IOException {
        TestDataSource datosOrigenCSV =
                new CSVTestDataSource(
                        RUTA_RECURSOS_DATOS_CSV
                                + PREFIJO_NOMBRE_DATOS_CSV
                                + nombreCSV
                                + EXTENSION_NOMBRE_DATOS_CSV,
                        SEPARADOR_VALORES_CSV);
        return obtenerDatosFiltrados(datosOrigenCSV, filtro);
    }

    /**
     * Filtra los datos obtenidos de la fuente CSV según los valores del filtro.
     *
     * @param datosCSV fuente de datos CSV
     * @param cadenaListadoFiltros cadena con los valores del filtro separados por coma
     * @return lista filtrada de mapas con los datos CSV
     * @throws NoSuchElementException si el filtro no arroja resultados
     */
    private static List<Map<String, String>> obtenerDatosFiltrados(TestDataSource datosCSV, String cadenaListadoFiltros) {
        List<Map<String, String>> lstTotalDatosCSV = datosCSV.getData();
        if ("".equals(cadenaListadoFiltros)) {
            // Si el filtro está vacío, retorna todos los datos
            return lstTotalDatosCSV;
        }
        String[] arrListadoFiltros = cadenaListadoFiltros.split(SEPARADOR_COMA);
        List<Map<String, String>> lstDatosFiltrados = filtrarDatos(arrListadoFiltros, lstTotalDatosCSV);
        if (lstDatosFiltrados != null && lstDatosFiltrados.size() > 0 ){
            return lstDatosFiltrados;
        } else {
            // Si no hay resultados, lanza excepción con mensaje descriptivo
            throw new NoSuchElementException(
                    String.format("El filtrado de datos no arrojo resultados. Lista de filtros usado: [%s]", cadenaListadoFiltros));
        }
    }

    /**
     * Realiza el filtrado real de los datos, comparando el valor de la columna 'idFiltro'
     * con la lista de filtros recibida.
     *
     * @param arrListaFiltros arreglo con los valores de filtro
     * @param listaTotalDatos lista completa de datos (cada elemento es un mapa fila)
     * @return lista filtrada con los mapas que coinciden con el filtro
     */
    private static List<Map<String, String>> filtrarDatos(
            String[] arrListaFiltros, List<Map<String, String>> listaTotalDatos) {
        return listaTotalDatos
                .stream()
                .filter(fila -> Utils.filtrarArreglo(arrListaFiltros, fila.get(NOMBRE_COLUMNA_FILTRO)))
                .collect(Collectors.toList());
    }
}
