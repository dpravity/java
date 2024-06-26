package programmers.level2.greedy;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 *
 * 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다.
 * 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
 *
 * 예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg 이라면
 * 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg 이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
 *
 * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
 *
 * 사람들의 몸무게를 담은 배열 people 과 구명보트의 무게 제한 limit 가 매개변수로 주어질 때,
 * 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
 * 각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
 * 구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
 * 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
 *
 * 입출력 예
 * people	            limit	return
 * [70, 50, 80, 50]	    100	    3
 * [70, 80, 50]	        100	    3
 */
public class LifeBoat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution1(people, limit));
//        System.out.println(solution2(people, limit));
        System.out.println(solution3(people, limit));
    }
    public static int solution1(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        for(int i = people.length - 1, index = 0; i > index; i--){
            if(people[i] + people[index] <= limit){
                index++;
                answer++;
            }else{
                answer++;
            }
        }

        return answer;
    }

    public static int solution2(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        for (int j = people.length - 1; i < j; --j) {
            if (people[i] + people[j] <= limit) {
                ++i;
            }
        }
        return people.length - i;
    }

    //#region - practice
    public static int solution3(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int from = 0;
        for(int to = people.length - 1; to > from; to--){
            if(people[from] + people[to] <= limit){
                answer++;
                from++;
            }else{
                answer++;
            }
        }

        return answer;
    }
    //#endregion - practice

}
