package cn.edu.dll.basic;

import java.util.List;

public class BasicCalculation {
    public static double getPrecisionValue(double originalValue, int precision) {
        String formatStr = "%." + precision + "f";
        String doubleStr =  String.format(formatStr, originalValue);
        return Double.valueOf(doubleStr);
    }
    public static Double get2Norm(List<Double> pointA, List<Double> pointB) {
        if (pointA.size() != pointB.size()) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.size();
        Double result = 0D;
        for (int i = 0; i < len; i++) {
            result += Math.pow(pointA.get(i)-pointB.get(i), 2);
        }
        return Math.sqrt(result);
    }
}
