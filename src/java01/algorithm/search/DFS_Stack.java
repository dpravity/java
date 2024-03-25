package java01.algorithm.search;

import java.util.Stack;

/**
 * 깊이 우선 탐색(DFS) 스택
 */
public class DFS_Stack {
    public static void main(String[] args) {
        // 방문 검사 배열
        boolean[] isVisited = new boolean[4];
        Stack<Integer> stack = new Stack<>();
        // 초기 상태
        stack.add(0);
        // 탐색 진행
        while (!stack.isEmpty()) {
            int state = stack.pop();
            System.out.print(state + " ");

            // 중복 검사
            if(isVisited[state]) {
                continue;
            }
            isVisited[state] = true;

            // 현재 상태 처리
            // 현재 상태 state 에 대한 처리

            // 전이 상태 생성
            for(int next : getNextStates(state)){
                // 범위 검사
                if(next < 0 || next >= 4) {
                    continue;
                }

                // 유효성 검사
                if(isVisited[next]) {
                    continue;
                }

                // 상태 전이
                stack.push(next);
            }
        }
    }

    private static int[] getNextStates(int state) {
        // TODO: state 에 대한 다음 상태 생성
        return new int[0];
    }

}
