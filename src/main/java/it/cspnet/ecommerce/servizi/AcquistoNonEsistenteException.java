/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.ecommerce.servizi;

/**
 *
 * @author corsojava
 */
public class AcquistoNonEsistenteException extends Exception {

    public AcquistoNonEsistenteException() {
    }

    public AcquistoNonEsistenteException(String message) {
        super(message);
    }

    public AcquistoNonEsistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public AcquistoNonEsistenteException(Throwable cause) {
        super(cause);
    }

    public AcquistoNonEsistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
}
