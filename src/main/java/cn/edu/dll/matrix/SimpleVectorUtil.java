package cn.edu.dll.matrix;

import java.util.List;

public class SimpleVectorUtil {
    public static Double getInnerProduct(List<Double> vectorA, List<Double> vectorB) {
        if (vectorA.size() != vectorB.size()) {
            throw new IllegalArgumentException("vectorA and vectorB must have the same size");
        }
        double result = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            result += vectorA.get(i) * vectorB.get(i);
        }
        return result;
    }
}
