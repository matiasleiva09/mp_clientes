package uy.com.servicios.mercadopago.infrastructure.excepcion;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
