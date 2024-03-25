package java01.algorithm.search;

public class Test {
    public static void main(String[] args) {
//        int[][] arr = new int[3][2];
         int[][] arr = {
                   {1, 2}
                 , {3, 4}
                 , {5, 6}
         };
        System.out.println(arr.length); // 행의 개수
        System.out.println(arr[0].length); // 열의 개수
        System.out.println("=============");
        print(arr);
    }
    public static void print(int[][] arr) {
        // 행과 열 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // 행 출력
        System.out.println("행 출력");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        // 열 출력
        System.out.println("열 출력");
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}
