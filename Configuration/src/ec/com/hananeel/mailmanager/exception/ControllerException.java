package ec.com.hananeel.mailmanager.exception;


public class ControllerException extends Exception {
    @SuppressWarnings("compatibility:-6185947606618331663")
    private static final long serialVersionUID = 1L;

    public ControllerException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public ControllerException(Throwable throwable) {
        super(throwable);
    }

    public ControllerException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ControllerException(String string) {
        super(string);
    }

    public ControllerException() {
        super();
    }
}
