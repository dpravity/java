package programmers.level0;

import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        int size = numbers.length;
        for(int i = 0; i < size; i++){
            sum += numbers[i];
        }
        double result = Double.valueOf(sum).doubleValue() / Double.valueOf(size).doubleValue();
        System.out.println(result);

        System.out.println(Arrays.stream(numbers).average().orElse(0.0));
    }
}
