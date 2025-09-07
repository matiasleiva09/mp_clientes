package uy.com.servicios.mercadopago.infrastructure.log;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.MDC;

import java.util.UUID;
/*
 CUANDO VIENE UNA PETICION NUEVA SE GENERA UN TRACE-ID O UNA TRAZA
 PARA QUE SI OCURRE UN ERROR SE PUEDA SEGUIR LOS LOGS CON MAYOR FACILIDAD
 */
@Provider
public class RequestHandler implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext context) {
        String traceId = UUID.randomUUID().toString();
        MDC.put("traceId", traceId);
    }
}