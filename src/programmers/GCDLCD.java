package programmers;

/**
 * 최대 공약수
 * 최소 공배수
 */
public class GCDLCD {
    public static void main(String[] args) {
        int[] array = {2, 6, 8, 14};
        System.out.println("the lowest common multiple : " + LCM(array[0], array[1]));
        System.out.println("the lowest common multiple array : " + LCMArray(array));
    }

    public static int GCD(int a, int b){
        if(a % b == 0){
            return b;
        }
        return GCD(b, a % b);
    }

    public static int LCM(int a, int b){
        int gcd = GCD(a, b);
        int lcm = (a * b) / gcd;
        System.out.println("GCD : " + gcd);
        System.out.println("LCM : " + lcm);
        return lcm;
    }

    public static int LCMArray(int[] array){
        if(array.length == 1){
            return array[0];
        }

        int gcd = GCD(array[0], array[1]);
        int lcm = (array[0] * array[1]) / gcd;

        for(int i = 2; i < array.length; i++){
            gcd = GCD(lcm, array[i]);
            lcm = (lcm * array[i]) / gcd;
        }
        System.out.println("GCD : " + gcd);
        System.out.println("LCM : " + lcm);

        return lcm;
    }
}
