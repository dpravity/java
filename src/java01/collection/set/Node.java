package java01.collection.set;

/**
 * Node 를 기반으로 하는 구현
 *
 * @param <E>
 */
public class Node<E> {

    // Key 해시 값
    final int hash;
    // Key 값, Set 에서는 Key 가 value 이다
    final E key;
    // Next Node 를 가르킴
    Node<E> next;

    public Node(int hash, E key, Node<E> next) {
        this.hash = hash;
        this.key = key;
        this.next = next;
    }

}
