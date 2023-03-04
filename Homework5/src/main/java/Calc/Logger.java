package Calc;

public class Logger implements DataLoger {

    String msg;
    int errorCode;
    Object tag;

    public Logger(String msg, int errorCode, Object tag) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.tag = tag;
    }
    public Logger(String msg, int errorCode) {
        this(msg, errorCode, null);
    }
    public Logger(String msg) {
        this(msg, 0, null);
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public Object getTag() {
        return null;
    }
}
