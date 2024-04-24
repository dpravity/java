package programmers.level0;
// 7, 3
// 2333
public class Test2 {
    public static void main(String[] args) {
        double temp = Double.valueOf(7).doubleValue() / Double.valueOf(3).doubleValue() * 1000;
        int answer = (int) temp;
        System.out.println(temp);
        System.out.println(answer);
        System.out.println(7 * 1000 / 3);
    }
}
