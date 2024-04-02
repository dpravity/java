package java01.algorithm.search;

/**
 * ### 주석 설명
 * - **`query` 메소드 (사용자 인터페이스)**: 사용자가 구간 합을 쿼리할 때 사용하는 메소드입니다.
 * 이 메소드는 실제 구간 합 계산을 위해 내부적으로 오버로드된 `query` 메소드를 호출합니다.
 *
 * - **`query` 메소드 (재귀)**: 세그먼트 트리의 특정 구간 [startIndex, endIndex]에 대한 합을 계산하는 재귀 메소드입니다.
 * 이 메소드는 현재 노드가 표현하는 구간이 쿼리와 겹치지 않으면 0을 반환하고, 구간이 완전히 쿼리에 포함되면 그 구간의 합을 반환합니다.
 * 그렇지 않은 경우, 쿼리 구간을 두 부분으로 나누어 각각의 합을 재귀적으로 계산한 다음, 그 결과를 합쳐서 반환합니다.
 *
 * - **`main` 함수**: 세그먼트 트리의 구현을 실제로 테스트하는 메인 함수입니다.
 * 이 예제에서는 6개의 요소를 가진 배열 `arr`에 대한 세그먼트 트리를 생성하고, 두 개의 서로 다른 구간 [1, 3]과 [0, 5]에 대한 구간 합 쿼리를 수행합니다.
 * 결과적으로 각 쿼리에 대한 구간 합을 출력합니다.
 *
 * 이 예제는 세그먼트 트리를 사용하여 구간 합 문제를 해결하는 기본적인 방법을 보여줍니다.
 * 세그먼트 트리는 구간 합 외에도 구간 내 최소값, 최대값, 최대 공약수 등 다양한 구간 쿼리 문제에 활용될 수 있습니다.
 * 실제 코딩 테스트나 알고리즘 대회에서 세그먼트 트리를 사용하려면, 레이지 업데이트(Lazy Propagation) 같은 추가 기법을 이해하고 적용할 수 있어야 합니다.
 * 이러한 기법을 통해 범위 업데이트와 같은 복잡한 연산도 효율적으로 처리할 수 있습니다.
 */

public class SegmentTree {
    int[] tree; // 세그먼트 트리를 저장하는 배열
    int n; // 원본 배열의 크기

    // 세그먼트 트리 생성자
    public SegmentTree(int[] arr) {
        n = arr.length; // 원본 배열의 크기를 n에 저장
        tree = new int[n * 4]; // 세그먼트 트리는 원본 배열 크기의 약 4배 필요
        buildTree(arr, 1, 0, n - 1); // 세그먼트 트리 구축
    }

    /**
     * 세그먼트 트리를 구축하는 메소드
     * @param arr   원본 배열
     * @param treeIndex 현재 노드의 인덱스
     * @param currentNodeStartIndex    현재 노드가 나타내는 구간의 시작 인덱스
     * @param currentNodeEndIndex    현재 노드가 나타내는 구간의 끝 인덱스
     */
    private void buildTree(int[] arr, int treeIndex, int currentNodeStartIndex, int currentNodeEndIndex) {
        if (currentNodeStartIndex == currentNodeEndIndex) { // 리프 노드인 경우
            tree[treeIndex] = arr[currentNodeStartIndex]; // 리프 노드에 원본 배열의 값을 저장
            return;
        }

        int mid = currentNodeStartIndex + (currentNodeEndIndex - currentNodeStartIndex) / 2; // 중간 지점 계산
        // 왼쪽 자식 노드를 재귀적으로 구축
        buildTree(arr, 2 * treeIndex, currentNodeStartIndex, mid);
        // 오른쪽 자식 노드를 재귀적으로 구축
        buildTree(arr, 2 * treeIndex + 1, mid + 1, currentNodeEndIndex);
        // 부모 노드는 자식 노드의 합을 저장
        tree[treeIndex] = tree[2 * treeIndex] + tree[2 * treeIndex + 1];
    }

    /**
     * 특정 인덱스에 해당하는 원소를 새로운 값으로 업데이트하는 메소드
     * @param index 업데이트할 원소의 인덱스
     * @param value 새로운 값
     */
    public void update(int index, int value) {
        update(1, 0, n - 1, index, value);
    }

    /**
     * 실제 업데이트를 수행하는 재귀 메소드
     * @param treeIndex 현재 노드의 인덱스
     * @param currentNodeStartIndex    현재 노드가 나타내는 구간의 시작 인덱스
     * @param currentNodeEndIndex    현재 노드가 나타내는 구간의 끝 인덱스
     * @param index 업데이트할 원소의 인덱스
     * @param value 새로운 값
     */
    public void update(int treeIndex, int currentNodeStartIndex, int currentNodeEndIndex, int index, int value) {
        if (currentNodeStartIndex == currentNodeEndIndex) {
            tree[treeIndex] = value;
            return;
        }
        int mid = currentNodeStartIndex + (currentNodeEndIndex - currentNodeStartIndex) / 2;
        if (index <= mid) {
            update(2 * treeIndex, currentNodeStartIndex, mid, index, value);
        } else {
            update(2 * treeIndex + 1, mid + 1, currentNodeEndIndex, index, value);
        }
        tree[treeIndex] = tree[2 * treeIndex] + tree[2 * treeIndex + 1];
    }

    /**
     * 구간 [startIndex, endIndex] 에 대한 쿼리를 수행하는 메소드
     * @param startIndex 구간의 시작 인덱스, left
     * @param endIndex 구간의 끝 인덱스, right
     * @return
     */
    public int query(int startIndex, int endIndex) {
        // 구간 [startIndex, endIndex]에 대한 쿼리를 수행하고 결과를 반환
        return query(1, 0, n - 1, startIndex, endIndex);
    }

    /**
     * 실제 구간 합을 계산하는 재귀 메소드
     * 구간 [startIndex, endIndex]에 대한 쿼리를 수행하는 메소드
     * @param treeIndex 현재 노드의 인덱스
     * @param currentNodeStartIndex    현재 노드가 나타내는 구간의 시작 인덱스
     * @param currentNodeEndIndex    현재 노드가 나타내는 구간의 끝 인덱스
     * @param startIndex 구간 합을 구하고자 하는 구간의 시작 인덱스
     * @param endIndex 구간 합을 구하고자 하는 구간의 끝 인덱스
     * @return
     */
    private int query(int treeIndex, int currentNodeStartIndex, int currentNodeEndIndex, int startIndex, int endIndex) {
        if (currentNodeStartIndex > endIndex || currentNodeEndIndex < startIndex) return 0; // 쿼리 구간과 겹치지 않는 경우
        if (startIndex <= currentNodeStartIndex && currentNodeEndIndex <= endIndex) return tree[treeIndex]; // 현재 구간이 쿼리 구간에 완전히 포함되는 경우

        int mid = currentNodeStartIndex + (currentNodeEndIndex - currentNodeStartIndex) / 2;    // 중간 지점 계산
        if (startIndex > mid) {
            // 쿼리 구간이 현재 구간의 오른쪽에 있는 경우
            return query(2 * treeIndex + 1, mid + 1, currentNodeEndIndex, startIndex, endIndex);
        } else if (endIndex <= mid) {
            // 쿼리 구간이 현재 구간의 왼쪽에 있는 경우
            return query(2 * treeIndex, currentNodeStartIndex, mid, startIndex, endIndex);
        }

        // 쿼리 구간이 현재 구간을 걸치는 경우, 왼쪽과 오른쪽 서브트리의 결과를 합쳐서 반환
        int leftQuery = query(2 * treeIndex, currentNodeStartIndex, mid, startIndex, mid);
        int rightQuery = query(2 * treeIndex + 1, mid + 1, currentNodeEndIndex, mid + 1, endIndex);
        return leftQuery + rightQuery;
    }

    // 메인 함수에서 세그먼트 트리 사용 예시
    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 7, 9, 11}; // 원본 배열
//        SegmentTree segTree = new SegmentTree(arr); // 세그먼트 트리 생성
//
//        // 구간 [1, 3]의 합 쿼리
//        System.out.println("Sum of values in range [1, 3]: " + segTree.query(1, 3));
//        // 구간 [0, 5]의 합 쿼리
//        System.out.println("Sum of values in range [0, 5]: " + segTree.query(0, 5));

        int d = -11;

        int[] arr = {1, 2, 3, 4, 5}; // 원본 배열
        SegmentTree segTree = new SegmentTree(arr); // 세그먼트 트리 생성

        // 구간 [1, 3]의 합 쿼리 9
        System.out.println("Sum of values in range [1, 3]: " + segTree.query(1, 3));
        segTree.update(1, 0);
        System.out.println("Sum of values in range [1, 3]: " + segTree.query(1, 3));
        // 구간 [0, 5]의 합 쿼리 15
//        System.out.println("Sum of values in range [0, 5]: " + segTree.query(0, 5));
    }
}