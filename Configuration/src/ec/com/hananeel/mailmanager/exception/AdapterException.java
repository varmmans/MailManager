package ec.com.hananeel.mailmanager.exception;

import ec.com.hananeel.mailmanager.qualifier.Component;

@Component
public class AdapterException extends Throwable {
    @SuppressWarnings("compatibility:7605100967957297501")
    private static final long serialVersionUID = -6839695790751096104L;


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
