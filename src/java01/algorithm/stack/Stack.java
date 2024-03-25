package java01.algorithm.stack;

public class Stack {
    private int maxSize; // Stack max size
    private int[] stackArray;   // stack 배열
    private int top;    // position

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;  // stack 비어있는 상태
    }

    // stack 에 요소 추가
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            stackArray[++top] = value;
        }
    }

    // stack 최상위 요소를 제거하고 반환
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // stack 최상위 요소를 반환
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // stack 비어있는지 확인
    public boolean isEmpty() {
        return (top == -1);
    }

    // stack 가득 찼는지 확인
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        stack.push(4);  // Stack is full
        System.out.println(stack.pop());  // 3
        System.out.println(stack.peek());  // 2
    }
}
