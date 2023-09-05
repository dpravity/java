package java01.exception;

public class ExceptionMain {

    public static void main(String[] args) {
        try {
            startInstall();
            copyFile();
            System.out.println();
        } catch (SpaceException e1){
            System.out.println("에러 메세지 : " + e1.getMessage());
            e1.printStackTrace();
            System.out.println("공간을 확보한 후 재설치 하시오");
        } catch (MemoryException e2){
            System.out.println("에러 메세지 : " + e2.getMessage());
            e2.printStackTrace();
            System.out.println("메모리를 확보한 후 재설치 하시오");
        }
    }

    private static void startInstall() throws SpaceException, MemoryException {
        if(!enoughSpace()){
            throw new SpaceException("공간이 부족합니다");
        }

        if (!enoughMemory()){
            throw new MemoryException("메모리가 부족합니다");
        }
    }

    private static void copyFile() {
        System.out.println("파일 복사중");
    }

    static boolean enoughSpace(){
        return false;
    }

    static boolean enoughMemory(){
        return true;
    }



}
