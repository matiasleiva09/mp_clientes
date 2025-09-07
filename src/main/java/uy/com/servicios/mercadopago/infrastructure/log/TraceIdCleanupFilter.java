package uy.com.servicios.mercadopago.infrastructure.log;


import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.MDC;
/*
 ESTA CLASE VA A LIMPIAR EL TRACE-ID GENERADO
 */
@Provider
public class TraceIdCleanupFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MDC.clear();
    }
}