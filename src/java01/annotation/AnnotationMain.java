package java01.annotation;

public class AnnotationMain {

    public static void main(String[] args) {
        print();
    }

    @ElapsedTime
    public static void print(){
        System.out.println("print");
    }

}
