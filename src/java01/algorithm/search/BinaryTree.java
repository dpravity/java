package java01.algorithm.search;

/**
 * 이진 탐색 트리 알고리즘
 */
public class BinaryTree {
    // 노드 클래스
    class Node {
        int key;    // 노드의 값
        Node left, right;   // 왼쪽, 오른쪽 자식 노드

        // 생성자
        public Node(int item) {
            key = item; // 노드의 값 초기화
            left = right = null;    // 자식 노드 초기화
        }
    }

    // 루트 노드
    Node root;

    // BinaryTree 생성자
    BinaryTree() {
        root = null;
    }

    /**
     * 이진 탐색 트리에 노드 추가
     * @param key
     */
    void insert(int key) {
        root = insertRecord(root, key);
    }

    /**
     * 이진 탐색 트리에 노드 추가
     * @param root
     * @param key
     * @return
     */
    Node insertRecord(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // 노드 추가
        if (key < root.key) {   // 노드의 값이 루트의 값보다 작으면 왼쪽 서브트리에 추가
            root.left = insertRecord(root.left, key);
        } else if (key > root.key) {    // 노드의 값이 루트의 값보다 크면 오른쪽 서브트리에 추가
            root.right = insertRecord(root.right, key);
        }

        return root;
    }

    /**
     * 전위 순회
     */
    void preOrder() {
        preOrderRecord(root);
    }

    /**
     * 전위 순회
     * @param root
     */
    void preOrderRecord(Node root) {
        if (root != null) {
            System.out.println(root.key);
            // 왼쪽 서브트리 순회
            preOrderRecord(root.left);
            // 오른쪽 서브트리 순회
            preOrderRecord(root.right);
        }
    }

    /**
     * 중위 순회
     */
    void inOrder() {
        inOrderRecord(root);
    }

    /**
     * 중위 순회
     * @param root
     */
    void inOrderRecord(Node root) {
        if (root != null) {
            // 왼쪽 서브트리 순회
            inOrderRecord(root.left);
            System.out.println(root.key);
            // 오른쪽 서브트리 순회
            inOrderRecord(root.right);
        }
    }

    /**
     * 후위 순회
     */
    void postOrder() {
        postOrderRecord(root);
    }

    /**
     * 후위 순회
     * @param root
     */
    void postOrderRecord(Node root) {
        if (root != null) {
            // 왼쪽 서브트리 순회
            postOrderRecord(root.left);
            // 오른쪽 서브트리 순회
            postOrderRecord(root.right);
            System.out.println(root.key);
        }
    }

    /**
     * 이진 탐색 트리에서 노드 검색
     * @param key
     * @return
     */
    boolean search(int key) {
        return searchRecord(root, key);
    }

    /**
     * 이진 탐색 트리에서 노드 검색
     * @param root
     * @param key
     * @return
     */
    boolean searchRecord(Node root, int key) {
        if (root == null) {
            return false;
        }

        // 노드 검색
        if (root.key == key) {
            // 노드를 찾은 경우
            return true;
        } else if (root.key > key) {
            // 노드의 값이 찾는 값보다 크면 왼쪽 서브트리에서 검색
            return searchRecord(root.left, key);
        } else {
            // 노드의 값이 찾는 값보다 작으면 오른쪽 서브트리에서 검색
            return searchRecord(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("root : " + tree.root.key);
        System.out.println("---전위 순회---");
        tree.preOrder();
        System.out.println("---중위 순회---");
        tree.inOrder();
        System.out.println("---후위 순회---");
        tree.postOrder();
        System.out.println("---검색---");
        System.out.println(tree.search(20)); // true
    }
}
