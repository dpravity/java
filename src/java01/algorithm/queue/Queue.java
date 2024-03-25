package java01.algorithm.queue;

public class Queue {
    private int maxSize; // 큐의 최대 크기
    private int[] queueArray; // 큐 배열
    private int front; // 큐의 앞부분을 가리키는 인덱스
    private int rear; // 큐의 뒷부분을 가리키는 인덱스
    private int nItems; // 큐에 들어있는 요소의 개수

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0; // 첫 번째 요소의 위치
        this.rear = -1; // 마지막 요소의 위치
        this.nItems = 0; // 큐에 들어있는 요소의 개수
    }
    public int[] getQueueArray() {
        return queueArray;
    }
    // 큐에 요소 추가
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            // 원형 큐의 끝에 도달 했다면
            if (rear == maxSize - 1) {
                rear = -1; // rear 포인터가 배열의 끝에 도달하면 rear 포인터를 -1로 초기화
            }
            // rear 포인터를 증가시킨 후 rear 포인터가 가리키는 위치에 요소 추가
            queueArray[++rear] = value;
            nItems++;
        }
    }

    // 큐에서 요소 제거하고 반환
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;  // 큐가 비어있을 경우의 처리
        } else {
            int temp = queueArray[front++]; // front 포인터가 가리키는 요소를 temp 변수에 저장 후 front 포인터 증가
            // 원형 큐 끝에 도달했다면
            if (front == maxSize) {
                front = 0; // front 포인터가 배열의 끝에 도달하면 front 포인터를 0으로 초기화
            }
            nItems--;   // 큐에 들어있는 요소의 개수 감소
            return temp;
        }
    }

    // 큐의 첫 번째 요소를 반환
    public int peek () {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;  // 큐가 비어있을 경우의 처리
        } else {
            return queueArray[front];
        }
    }

    // 큐 비어있는지 확인
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // 큐 가득 찼는지 확인
    public boolean isFull() {
        return (nItems == maxSize);
    }


    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
//        queue.enqueue(4);  // Queue is full
        System.out.println(queue.dequeue());  // 1
        System.out.println(queue.dequeue());  // 2
        System.out.println(queue.peek());  // 3

//        queue.enqueue(4);
        System.out.println("q len : " + queue.getQueueArray().length);
        for(int i : queue.getQueueArray()) {
            System.out.println("q : " + i);
        }
    }
}
