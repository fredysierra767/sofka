package co.com.opencart.utils;

import net.serenitybdd.core.pages.PageObject;

public class Utils extends PageObject {

    public static boolean filtrarArreglo(String[] arr, String item) {
        if (arr.length > 0) {
            for (String n : arr) {
                if (item.equals(n)) {
                    return true;
                }
            }
        }
        return false;
    }

}
