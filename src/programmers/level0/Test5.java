package programmers.level0;

/*
예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return하도록 solution 함수를 완성해주세요.
예각 : 0 < angle < 90
직각 : angle = 90
둔각 : 90 < angle < 180
평각 : angle = 180
*/
public class Test5 {
    public static void main(String[] args) {
        int answer = 0;
        int a = 90;
        System.out.println(t1(a));

    }
    public static int t1(int angle){
        int answer = 0;
        if(angle == 90){
            answer = 1;
        }else if(90 < angle || angle < 180){
            answer = 2;
        }else if(angle == 90){
            answer = 3;
        }else{
            answer = 4;
        }
        return answer;
    }
    public static int t2(int angle){

        return 0;
    }
}
