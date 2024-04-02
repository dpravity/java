package java01.algorithm.crytolab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TreeGenerator
 * https://codeforces.com/problemset/problem/1149/C
 */
public class TreeGenerator {
    static int MAX_SIZE; // 세그먼트 트리 크기는 원소 수의 약 4배
    static Node[] tree;
    static char[] s;

    // 세그먼트 트리 노드 클래스
    static class Node {
        int sum;    // 구간 합
        int pmx;    // 구간의 부분 최대값
        int lmx;    // 구간의 왼쪽 끝에서의 최대값
        int mi;     // 구간의 최소값
        int ma;     // 구간의 최대값
        int d;      // 구간 내 최대 지름

        public Node() {
            sum = pmx = lmx = mi = ma = d = 0;
        }

        // 두 노드를 결합하는 함수
        static Node combine(Node left, Node right) {
            Node result = new Node();
            // 두 구간의 합계를 결합
            result.sum = left.sum + right.sum;
            // 최소값 결합
            result.mi = Math.min(left.mi, right.mi + left.sum);
            // 최대값 결합
            result.ma = Math.max(left.ma, right.ma + left.sum);
            // 부분 최대값 결합
            result.pmx = Math.max(left.pmx, Math.max(right.ma - 2 * left.mi + left.sum, right.pmx - left.sum));
            // 왼쪽 끝에서의 최대값 결합
            result.lmx = Math.max(left.lmx, Math.max(right.lmx - left.sum, left.ma - 2 * right.mi - 2 * left.sum));
            // 구간 내 최대 지름 결합
            result.d = Math.max(Math.max(left.d, right.d), Math.max(left.ma + right.pmx - left.sum, left.lmx + left.sum + right.ma));
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); // 괄호 문자열의 길이
        int q = Integer.parseInt(firstLine[1]); // 교환 횟수
        s = br.readLine().toCharArray();    // 괄호 문자열
        n = n * 2 - 2; // 실제 사용될 길이

        // MAX_SIZE 및 tree 배열의 크기를 동적으로 계산하고 초기화
        MAX_SIZE = calcTreeSize(n);
        tree = new Node[MAX_SIZE];

        buildTree(1, 0, n - 1); // 세그먼트 트리 구축
        System.out.println(tree[1].d);  // 초기 지름 출력

        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;  // 교환 위치 1
            int y = Integer.parseInt(line[1]) - 1;  // 교환 위치 2

            swap(x, y); // 괄호 위치 교환
            // 교환된 위치에 대해 세그먼트 트리 업데이트
            update(1, 0, n - 1, x);
            update(1, 0, n - 1, y);

            // 교환 후 지름 출력
            System.out.println(tree[1].d);
        }
    }

    // 세그먼트 트리 구축 메소드
    static void buildTree(int node, int start, int end) {
        // 리프 노드인 경우
        if (start == end) {
            // 리프 노드에서 괄호의 값에 따라 노드 초기화
            int val = s[start] == '(' ? 1 : -1;
            tree[node] = new Node();
            tree[node].sum = val;
            tree[node].mi = Math.min(0, val);
            tree[node].ma = Math.max(0, val);
            return;
        }
        // 중간 노드
        int mid = (start + end) / 2;
        // 왼쪽 자식 노드와 오른쪽 자식 노드에 대해 재귀적으로 세그먼트 트리 구축
        buildTree(node * 2, start, mid);
        buildTree(node * 2 + 1, mid + 1, end);
        // 부모 노드는 두 자식 노드의 결합으로 구성
        tree[node] = Node.combine(tree[node * 2], tree[node * 2 + 1]);
    }

    // 교환 후 세그먼트 트리 업데이트 메소드
    static void update(int node, int start, int end, int idx) {
        // 리프 노드인 경우
        if (start == end) {
            // 리프 노드 업데이트, 교환된 괄호를 기반으로 노드값 재설정
            int val = s[start] == '(' ? 1 : -1;
            tree[node] = new Node();
            tree[node].sum = val;
            tree[node].mi = Math.min(0, val);
            tree[node].ma = Math.max(0, val);
            return;
        }
        int mid = (start + end) / 2;
        // 교환된 괄호 위치에 따라 자식 노드로 이동
        if (idx <= mid) {
            // 왼쪽 자식 노드로 이동
            update(node * 2, start, mid, idx);
        } else {
            // 오른쪽 자식 노드로 이동
            update(node * 2 + 1, mid + 1, end, idx);
        }
        // 자식 노드의 업데이트를 기반으로 부모 노드 업데이트
        tree[node] = Node.combine(tree[node * 2], tree[node * 2 + 1]);
    }

    // 괄호 위치를 교환하는 함수
    static void swap(int x, int y) {
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }
    // n 이상의 최소 2의 거듭제곱을 찾는 메소드
    static int calcTreeSize(int n) {
        int size = 1;
        while (size < n) size <<= 1;
        return size << 2; // 세그먼트 트리의 크기는 리프 노드 수의 4배
    }
}
