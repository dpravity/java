package java01.algorithm.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 탐욕 알고리즘
 * 문제 : 체육복 (프로그래머스)
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Greedy_1 {
    public static void main(String[] args) {
        int n = 5;  // 전체 학생 수
        int[] lost = {2, 4};    // 도난당한 학생 번호
        int[] reserve = {1, 3, 5};  // 여벌의 체육복을 가져온 학생 번호

        System.out.println("체육복 있는 수업 가능 학생 수 : " + solution(n, lost, reserve));  // 5
    }

    public static int solution(int n , int[] lost, int[] reserve){
        Arrays.sort(lost);  // 오름차순 정렬
        Arrays.sort(reserve);   // 오름차순 정렬

        // 여벌의 체육복을 가져온 학생이 도난당한 경우
        Set<Integer> owns = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        // 여벌의 체육복을 가져온 학생이 도난당한 경우 제거
        owns.retainAll(Arrays.stream(reserve).boxed().collect(Collectors.toSet()));

        Queue<Integer> q = new LinkedList<>();
        // 도난당한 학생 번호를 큐에 삽입
        for(int l : lost){
            q.add(l);
        }

        int get = 0;    // 빌려준 학생 수

        // 여벌의 체육복을 가져온 학생이 도난당한 학생에게 빌려줄 수 있는 경우
        for(int r : reserve){
            // 여벌의 체육복을 가져온 학생이 도난당한 경우
            if(owns.contains(r)){
                continue;
            }

            // 여벌의 체육복을 가져온 학생이 도난당한 학생에게 빌려줄 수 있는 경우
            while(!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))){
                q.poll();
            }
            // 도난당한 학생이 없는 경우
            if(q.isEmpty()){
                break;
            }
            // 여벌의 체육복을 가져온 학생이 도난당한 학생에게 빌려줌
            if (q.peek() <= r + 1) {
                q.poll();
                get++;
            }
        }
        // 전체 학생 수 - 도난당한 학생 수 + 여벌의 체육복을 가져온 학생 수 + 빌려준 학생 수
        return n - lost.length + owns.size() + get;
    }
}
