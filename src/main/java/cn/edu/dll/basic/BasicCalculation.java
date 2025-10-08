package cn.edu.dll.basic;

public class BasicCalculation {
    public static double getPrecisionValue(double originalValue, int precision) {
        String formatStr = "%." + precision + "f";
        String doubleStr =  String.format(formatStr, originalValue);
        return Double.valueOf(doubleStr);
    }
}
