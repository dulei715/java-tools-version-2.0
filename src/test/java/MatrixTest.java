import cn.edu.dll.io.print.MyPrint;
import org.ejml.data.Complex_F64;
import org.ejml.simple.SimpleEVD;
import org.ejml.simple.SimpleMatrix;
import org.junit.Test;

public class MatrixTest {
    @Test
    public void fun1() {
        SimpleMatrix matrixA = new SimpleMatrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        SimpleMatrix matrixB = new SimpleMatrix(new double[][]{
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}
        });
        SimpleMatrix matrixC = matrixA.mult(matrixB);
//        System.out.println(matrixC);
        matrixC.print();
        MyPrint.showSplitLine("*", 150);

        SimpleMatrix matrixD = matrixA.invert();
        matrixD.print();
        MyPrint.showSplitLine("*", 150);

        SimpleMatrix matrixE = matrixA.transpose();
        matrixE.print();
    }
    @Test
    public void fun2() {
        SimpleMatrix matrixA = new SimpleMatrix(new double[][]{
                {2, 1},
                {1, 2}
        });

        SimpleEVD<SimpleMatrix> evd = matrixA.eig();
        int number = evd.getNumberOfEigenvalues();
        for (int i = 0; i < number; i++) {
            Complex_F64 eigenvalue = evd.getEigenvalue(i);
            SimpleMatrix eigenVector = evd.getEigenVector(i);
            System.out.println("第 " + i + " 个特征值：" + eigenvalue);
            System.out.println("对应的特征向量：");
            if (eigenVector != null) {
                eigenVector.print();
            } else {
                System.out.println("该特征值为复数，无特征向量");
            }
        }
    }
}
