/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author skevi
 */
public class ConexionException extends Exception{

    /**
     * 
     */
    public ConexionException() {
    }

    /**
     * 
     * @param message 
     */
    public ConexionException(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public ConexionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 
     * @param cause 
     */
    public ConexionException(Throwable cause) {
        super(cause);
    }

    /**
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace 
     */
    public ConexionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
