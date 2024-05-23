package programmers.level1.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 *
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve 가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 전체 학생의 수는 2명 이상 30명 이하입니다.
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 *
 * 입출력 예
 * n	lost	reserve	    return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	        4
 * 3	[3]	    [1]	        2
 *
 * 입출력 예 설명
 * 예제 #1
 * 1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
 *
 * 예제 #2
 * 3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
 */
public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution1(n, lost, reserve));
        System.out.println(solution2(n, lost, reserve));
        System.out.println(solution3(n, lost, reserve));
    }

    public static int solution1(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여별 체육복 있는데 도난당한 경우
        HashSet<Integer> own = Arrays.stream(lost).boxed().collect(Collectors.toCollection(HashSet::new));
        own.retainAll(Arrays.stream(reserve).boxed().collect(Collectors.toCollection(HashSet::new)));

        // 도난당한 사람 큐, 여별 체육복 있는데 도난당한 사람 제외
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i : lost){
            queue.offer(i);
        }

        // 빌려준 사람
        int lend = 0;

        for(int suit : reserve){
            // 여벌의 체육복을 가져온 학생이 도난당한 경우
            if(own.contains(suit)){
                continue;
            }

            // 여벌 옷 있으면 && 본인보다 뒷번호, 본인 도난 체크
            while(!queue.isEmpty() && (queue.peek() < suit - 1 || own.contains(queue.peek()))){
                queue.poll();
            }

            // 도난 없으면
            if(queue.isEmpty()){
                break;
            }

            // 여분 빌려주기
            if(queue.peek() <= suit + 1){
                queue.poll();
                lend++;
            }
        }
        // 전체 학생 수 - 도난당한 학생 수 + 여벌의 체육복을 가져온 학생 수 + 빌려준 학생 수
        return n - lost.length + own.size() + lend;
    }

    public static int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
            people[l - 1]--;
        }
        for (int r : reserve) {
            people[r - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i - 1 >= 0 && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                }else if(i + 1 < people.length && people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }

    //#region - practice
    public static int solution3(int n, int[] lost, int[] reserve) {
        int count = n;
        int[] people = new int[n];
        // 잃어버린 사람
        for(int i : lost){
            people[i - 1]--;
        }
        // 여분 있는 사람
        for(int i : reserve){
            people[i - 1]++;
        }

        for(int i = 0; i < people.length; i++){
            if(people[i] == -1){
                if(i - 1 >= 0 && people[i - 1] == 1){   // 앞사람 체크
                    people[i]++;
                    people[i - 1]--;
                } else if (i + 1 < people.length && people[i + 1] == 1) {  // 뒷사람 체크
                    people[i]++;
                    people[i + 1]--;
                }else{  // 못빌린 사람 제외
                    count--;
                }
            }
        }

        return count;
    }
    //#endregion - practice

}
