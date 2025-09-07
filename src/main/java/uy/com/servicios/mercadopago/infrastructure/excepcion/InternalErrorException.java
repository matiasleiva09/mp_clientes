package uy.com.servicios.mercadopago.infrastructure.excepcion;

public class InternalErrorException extends RuntimeException{
    public InternalErrorException(String message){
        super(message);
    }
}
