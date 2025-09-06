package uy.com.labanca.notificaciones.infrastructure.excepcion;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
