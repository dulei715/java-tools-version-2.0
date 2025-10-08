package cn.edu.dll.basic;


import cn.edu.dll.io.print.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class RandomUtil {

    /**
     *
     * @param lowerBound （包含在内）
     * @param upperBound （不包含在内）
     * @return
     */
    public static Double getRandomDouble(Double lowerBound, Double upperBound, Random random) {
        double randomValue = random.nextDouble();
        double realValue = randomValue * (upperBound - lowerBound) + lowerBound;
        return realValue;
    }

    /**
     *
     * @param lowerBound (包含在内)
     * @param upperBound (包含在内)
     * @return
     */
    public static Integer getRandomInteger(Integer lowerBound, Integer upperBound, Random random) {
        double randomValue = random.nextDouble();
        double realValue = randomValue * (upperBound + 1 - lowerBound) + lowerBound;
        Integer result = (int) Math.floor(realValue);
        return result;
    }

    public static Boolean isChosen(Double probability) {
        Double position = Math.random();
        if (position < probability) {
            return true;
        }
        return false;
    }

    public static Boolean isChosen(Double probability, Random random) {
        Double position = random.nextDouble();
        if (position < probability) {
            return true;
        }
        return false;
    }

    public static <T> List<T> getRandomElement(List<T> elementList, int sampleSize, Random random) {
        int lowerBound = 0;
        int upperBound = elementList.size() - 1;
        Integer index;
        List<T> sampleElementList = new ArrayList<>();
        for (int i = 0; i < sampleSize; i++) {
            index = getRandomInteger(lowerBound, upperBound, random);
            sampleElementList.add(elementList.get(index));
        }
        return sampleElementList;
    }

    public static <T> T getRandomElement(List<T> elementList, Random random) {
        List<T> randomElementList = getRandomElement(elementList, 1, random);
        return randomElementList.get(0);
    }



    /**
     * 返回随机整数数组（元素可以重复）
     * @param lowerBound
     * @param upperBound
     * @param arraySize
     * @return
     */
    public static Integer[] getRandomIntegerArray(Integer lowerBound, Integer upperBound, int arraySize, Random random) {
        Integer[] resultArray = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            resultArray[i] = getRandomInteger(lowerBound, upperBound, random);
        }
        return resultArray;
    }

    /**
     * 返回随机小数数组（元素可以重复）
     * @param lowerBound
     * @param upperBound
     * @param arraySize
     * @return
     */
    public static Double[] getRandomDoubleArray(Double lowerBound, Double upperBound, int arraySize, Random random) {
        Double[] resultArray = new Double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            resultArray[i] = getRandomDouble(lowerBound, upperBound, random);
        }
        return resultArray;
    }

    public static List<Integer> getRandomIntegerListWithoutRepeat(Integer lowerBound, Integer upperBound, int samplingSize, Random random) {
        int domainSize = upperBound - lowerBound + 1;
        if (samplingSize > domainSize) {
            throw new RuntimeException("The sampling size is larger than domain size!");
        }
        List<Integer> result = new ArrayList<>(samplingSize);
        int samplingPosition;
        Integer samplingElement;
        int residualMaxIndex = domainSize - 1;
        List<Integer> randomList = BasicArrayUtil.getIncreaseIntegerNumberList(lowerBound, 1, upperBound);
        for (int i = 0; i < samplingSize; i++) {
            samplingPosition = getRandomInteger(0, residualMaxIndex, random);

            samplingElement = randomList.remove(samplingPosition);
            result.add(samplingElement);
            -- residualMaxIndex;
        }

        return result;
    }
    public static List<Integer> getRandomIntegerList(Integer lowerBound, Integer upperBound, int samplingSize, Random random) {
        List<Integer> resultList = new ArrayList<>(samplingSize);
        Integer tempInteger;
        for (int i = 0; i < samplingSize; i++) {
            tempInteger = getRandomInteger(lowerBound, upperBound, random);
            resultList.add(tempInteger);
        }
        return resultList;
    }
    public static int[] getRandomIntArrayWithoutRepeat(int lowerBound, int upperBound, int samplingSize, Random random) {
        int domainSize = upperBound - lowerBound + 1;
        if (samplingSize > domainSize) {
            throw new RuntimeException("The sampling size is larger than domain size!");
        }
        int[] result = new int[samplingSize];
        int samplingPosition;
        Integer samplingElement;
        int residualMaxIndex = domainSize - 1;
        List<Integer> randomList = BasicArrayUtil.getIncreaseIntegerNumberList(lowerBound, 1, upperBound);
        for (int i = 0; i < samplingSize; i++) {
            samplingPosition = getRandomInteger(0, residualMaxIndex, random);

            samplingElement = randomList.remove(samplingPosition);
            result[i] = samplingElement;
            -- residualMaxIndex;
        }

        return result;
    }

    /**
     * 获取给定0到upperBoundValue之间的arraySize个随机数
     * @param arraySize
     * @param upperBoundValue
     * @return
     */
    public static Double[] getRandomDoubleArrayWithValuesInGivenRange(Integer arraySize, Double upperBoundValue, Random random) {
        Integer pointSize = arraySize - 1;
        Double[] pointArray = getRandomDoubleArray(0D, upperBoundValue, pointSize, random);
        Arrays.sort(pointArray);
        Double[] result = new Double[arraySize];
        Double beforeValue = 0D;
        int i;
        for (i = 0; i < pointSize; i++) {
            result[i] = pointArray[i] - beforeValue;
            beforeValue = pointArray[i];
        }
        result[i] = upperBoundValue - beforeValue;
        return result;
    }




    public static void main(String[] args) {
    }

}
