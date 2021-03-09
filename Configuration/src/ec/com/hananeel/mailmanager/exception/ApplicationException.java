package ec.com.hananeel.mailmanager.exception;


public class ApplicationException extends Exception {
    @SuppressWarnings("compatibility:6845981983080545434")
    private static final long serialVersionUID = 1L;

    public ApplicationException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public ApplicationException(Throwable throwable) {
        super(throwable);
    }

    public ApplicationException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ApplicationException(String string) {
        super(string);
    }

    public ApplicationException() {
        super();
    }
}
