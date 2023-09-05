package java01.exception;

public class SpaceException extends Exception {

    private final int ERROR_CODE;

    public SpaceException(String msg){
        this(msg, 100);
    }

    public SpaceException(String msg, int errorCode){
        super(msg);
        this.ERROR_CODE = errorCode;
    }

    public int getErrorCode(){
        return ERROR_CODE;
    }

}
