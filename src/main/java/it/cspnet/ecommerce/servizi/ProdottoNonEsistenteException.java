package it.cspnet.ecommerce.servizi;

public class ProdottoNonEsistenteException extends Exception {

    public ProdottoNonEsistenteException() {
    }

    public ProdottoNonEsistenteException(String message) {
        super(message);
    }

    public ProdottoNonEsistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProdottoNonEsistenteException(Throwable cause) {
        super(cause);
    }

    public ProdottoNonEsistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
}
