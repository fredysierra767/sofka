package co.com.opencart.utils;

import net.serenitybdd.screenplay.Actor;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static co.com.opencart.enums.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.opencart.utils.Accesos.RUTA_DESCARGAS;
import static co.com.opencart.utils.Accesos.RUTA_DRIVERS;
import static co.com.opencart.utils.Diccionario.ACTOR_NAME;

/**
 * Clase base para la configuración general del entorno de pruebas con Selenium y Serenity.
 *
 * Se encarga de:
 * - Configurar el actor principal de las pruebas.
 * - Inicializar el WebDriver de Chrome con opciones personalizadas.
 * - Configurar el sistema de logging Log4j.
 *
 * Esta clase puede ser extendida para reutilizar la configuración en distintos step definitions o tests.
 */
public class SetUp {

    /**
     * Actor principal utilizado en las pruebas Screenplay.
     */
    protected final Actor actor = Actor.named(ACTOR_NAME);

    /**
     * Driver del navegador utilizado para la automatización.
     */
    protected WebDriver webdriver;

    /**
     * Método principal para inicializar la configuración general:
     * - Configura Log4j.
     * - Establece la propiedad del driver de Chrome.
     * - Crea la instancia del ChromeDriver con las opciones personalizadas.
     */
    protected void setupGeneral() {
        setupLog4j();
        System.setProperty("webdriver.chrome.driver", RUTA_DRIVERS);
        webdriver = new ChromeDriver(configurarChrome());
    }

    /**
     * Configura las opciones del navegador Chrome para la ejecución de pruebas.
     *
     * Incluye:
     * - Directorio de descargas personalizado.
     * - Modo incógnito.
     * - Maximizar ventana.
     * - Configuración de logs de navegador y performance.
     * - Argumentos para estabilidad en ambientes Linux y otros.
     *
     * @return las opciones configuradas para Chrome.
     */
    protected ChromeOptions configurarChrome() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", RUTA_DESCARGAS);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1.0);
        prefs.put("traceCategories", "browser,devtools.timeline,devtools");
        prefs.put("enableNetwork", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        // options.addArguments("--headless"); // Descomentar para ejecución sin UI
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);

        return options;
    }

    /**
     * Configura Log4j a partir del archivo de propiedades definido en la constante.
     */
    private void setupLog4j() {
        PropertyConfigurator.configure(LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
