package cn.edu.dll.matrix;

import org.ejml.data.DMatrixRMaj;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtil {

    public static double[][] toBasicDoubleArray(List<List<Double>> matrix) {
        double[][] doubleArray = new double[matrix.size()][matrix.get(0).size()];
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                doubleArray[i][j] = matrix.get(i).get(j);
            }
        }
        return doubleArray;
    }

    public static double[][] toBasicDoubleArray(SimpleMatrix matrix) {
        DMatrixRMaj ddrm = matrix.getDDRM();
        int rows = ddrm.getNumRows();
        int cols = ddrm.getNumCols();
        double[][] result = new double[rows][cols];
        double[] data = ddrm.getData();
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data, i * cols, result[i], 0, cols);
        }
        return result;
    }

    public static Double[][] toDoubleArray(List<List<Double>> matrix) {
        Double[][] doubleArray = new Double[matrix.size()][matrix.get(0).size()];
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                doubleArray[i][j] = matrix.get(i).get(j);
            }
        }
        return doubleArray;
    }

    public static List<List<Double>> toTwoLayerList(double[][] matrix) {
        List<List<Double>> resultList = new ArrayList<>();
        List<Double> tempList;
        for (int i = 0; i < matrix.length; i++) {
            tempList = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                tempList.add(matrix[i][j]);
            }
            resultList.add(tempList);
        }
        return resultList;
    }

    public static List<List<Double>> multiple(List<List<Double>> matrixA, List<List<Double>> matrixB) {
        SimpleMatrix simpleMatrixA = new SimpleMatrix(toBasicDoubleArray(matrixA));
        SimpleMatrix simpleMatrixB = new SimpleMatrix(toBasicDoubleArray(matrixB));
        SimpleMatrix resultMatrix = simpleMatrixA.mult(simpleMatrixB);
        return toTwoLayerList(toBasicDoubleArray(resultMatrix));
    }

    public static void main(String[] args) {
        double[][] dataA = {{1,2}, {3,4}};
        double[][] dataB = {{5,6}, {7,8}};
//        RealMatrix matrixA = new Array2DRowRealMatrix(dataA);
//        RealMatrix matrixB = new Array2DRowRealMatrix(dataB);
//        RealMatrix sum = matrixA.add(matrixB);
//        RealMatrix product = matrixA.multiply(matrixB);
//        System.out.println(sum);
//        System.out.println(product);
        SimpleMatrix matrixA = new SimpleMatrix(dataA);
        SimpleMatrix matrixB = new SimpleMatrix(dataB);
        SimpleMatrix matrixSum = matrixA.plus(matrixB);
        SimpleMatrix matrixProduct = matrixA.mult(matrixB);
        System.out.println(matrixSum);
        System.out.println(matrixProduct);
    }
}