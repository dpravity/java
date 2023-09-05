package java01.collection.set;

public class HashSet<E> implements Set<E> {

    // << : shift 연산자, 비트를 좌측으로 밀어서 이동
    // ex) 0001 << 2
    public static final int DEFAULT_CAPACITY = 1 << 4;


    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public boolean contains() {
        return false;
    }

    @Override
    public boolean equals() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
