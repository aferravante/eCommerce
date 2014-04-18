package it.cspnet.ecommerce.servizi;

public class CategoriaNonEsistenteException extends Exception {

    public CategoriaNonEsistenteException() {
    }

    public CategoriaNonEsistenteException(String message) {
        super(message);
    }

    public CategoriaNonEsistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoriaNonEsistenteException(Throwable cause) {
        super(cause);
    }

    public CategoriaNonEsistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
}
