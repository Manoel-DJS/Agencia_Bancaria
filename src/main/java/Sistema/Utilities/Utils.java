package Sistema.Utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    // Formatação de números
    static NumberFormat formatNumber = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(double valor){
        return formatNumber.format(valor);
    }
}
