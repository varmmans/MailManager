package ec.com.hananeel.mailmanager.exception;


public class AdapterException extends Exception {
    @SuppressWarnings("compatibility:-2725546743334523104")
    private static final long serialVersionUID = 1L;

    public AdapterException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public AdapterException(Throwable throwable) {
        super(throwable);
    }

    public AdapterException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public AdapterException(String string) {
        super(string);
    }

    public AdapterException() {
        super();
    }
}
