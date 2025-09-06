package uy.com.labanca.notificaciones.infrastructure.excepcion;

public class InternalErrorException extends RuntimeException{
    public InternalErrorException(String message){
        super(message);
    }
}
