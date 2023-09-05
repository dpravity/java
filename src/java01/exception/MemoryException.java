package java01.exception;

public class MemoryException extends Exception {

    private final int ERROR_CODE;

    public MemoryException(String msg){
        this(msg, 100);
    }

    public MemoryException(String msg, int errorCode){
        super(msg);
        this.ERROR_CODE = errorCode;
    }

    public int getErrorCode(){
        return ERROR_CODE;
    }

}
