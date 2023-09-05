package java01.exception;

public class CustomException extends RuntimeException {

    private final int ERROR_CODE;

    public CustomException(String msg){
        this(msg, 100);
    }

    public CustomException(String msg, int errorCode){
        super(msg);
        this.ERROR_CODE = errorCode;
    }

    public int getErrorCode(){
        return ERROR_CODE;
    }

}
