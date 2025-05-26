package mascotas;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParallelTest {

    // Test principal que ejecuta el feature orquestador del flujo de mascota
    @Test
    void testFlujoMascota() {
        Results results = Runner
                .path("classpath:mascotas/flujo_mascota.feature") // ⚠️ Ejecuta solo el feature orquestador
                .outputCucumberJson(true)                          // Habilita salida JSON para el reporte
                .outputHtmlReport(true)                            // Habilita salida HTML
                .parallel(1);                                      // Se ejecuta secuencialmente (1 hilo)

        // Genera reporte HTML con los resultados de la ejecución
        generateReport(results.getReportDir());

        // Verifica que no haya fallos en la ejecución
        assertEquals(0, results.getFailCount(), "Hay escenarios fallidos:\n" + results.getErrorMessages());
    }

    // Método para generar el reporte de resultados en HTML con Cucumber Reports
    public static void generateReport(String karateOutputPath) {
        File reportOutputDir = new File("target/karate-reports"); // Carpeta de salida para el reporte

        // Recopila todos los archivos JSON generados por Karate
        Collection<File> jsonFiles = FileUtils.listFiles(
                new File(karateOutputPath), new String[]{"json"}, true
        );

        List<String> jsonPaths = new ArrayList<>();
        for (File file : jsonFiles) {
            jsonPaths.add(file.getAbsolutePath());
        }

        // Configura el generador de reportes con información adicional
        Configuration config = new Configuration(reportOutputDir, "karate-mascotas");
        config.setBuildNumber("1");
        config.addClassifications("Proyecto", "PetStore API");
        config.addClassifications("Entorno", "QA");
        config.addClassifications("Equipo", "Automatización");
        config.addClassifications("Ejecutor", System.getProperty("user.name"));

        // Construye y genera el reporte final
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
