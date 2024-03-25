package java01.algorithm.search;

/**
 * 해시 테이블
 */
public class HashTable {
    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // 해시 테이블

    // 해시 테이블의 엔트리
    class HashEntry {
        String key; // 키
        String value;   // 값
        HashEntry next; // 다음 엔트리

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // 생성자
    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    /**
     * 해시 함수, 키를 받아서 해시 테이블의 인덱스를 반환
     * @param key
     * @return
     */
    private int getIndex(String key) {
        int hashCode = key.hashCode();
        // 0x7fffffff는 16진수로 0111 1111 1111 1111 1111 1111 1111 1111
        // hashCode & 0x7fffffff는 hashCode의 부호 비트를 0으로 만들어 양수로 만드는 역할
        // hashCode & 0x7fffffff의 결과를 배열의 크기로 나누어 배열의 인덱스를 구함
        // hashCode가 음수일 경우 음수를 양수로 바꾸기 위해 0x7fffffff를 사용
        // int 자료형 최댓값 2147483647 = 0x7fffffff
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;
        return index;
    }

    /**
     * 키와 값을 해시 테이블에 추가
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        int index = getIndex(key);
        HashEntry entry = new HashEntry(key, value);

        if (data[index] == null) {
            data[index] = entry;
        } else {
            // 해시 충돌 발생 시 연결 리스트로 연결
            HashEntry entries = data[index];
            while (entries.next != null) {
                entries = entries.next;
            }
            entries.next = entry;
        }
    }

    /**
     * 키에 해당하는 값을 반환
     * @param key
     * @return
     */
    public String get(String key) {
        int index = getIndex(key);
        HashEntry entries = data[index];

        // 연결 리스트를 순회하며 키에 해당하는 값을 찾음
        // 연결 리스트의 마지막 노드까지 찾아도 키에 해당하는 값이 없으면 null 반환
        if (entries != null) {
            // hashCode가 같아도 다른 키일 수 있으므로 key.equals(key)로 키를 비교
            while (!entries.key.equals(key) && entries.next != null) {
                entries = entries.next;
            }
            return entries.value;
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put("name", "minho");
        hashTable.put("age", "25");
        hashTable.put("city", "seoul");

        System.out.println(hashTable.get("name")); // minho
        System.out.println(hashTable.get("age")); // 25
        System.out.println(hashTable.get("city")); // seoul
    }
}
