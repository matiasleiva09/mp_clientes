package uy.com.servicios.mercadopago.infrastructure.excepcion.mappers;


import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.MDC;
import uy.com.servicios.mercadopago.infrastructure.excepcion.ErrorDTO;
import uy.com.servicios.mercadopago.infrastructure.excepcion.InternalErrorException;

import java.time.OffsetDateTime;

@Provider
public class InternalServerExceptionMapper implements ExceptionMapper<InternalErrorException> {
    @Override
    public Response toResponse(InternalErrorException e) {
        return Response.status(500).entity(ErrorDTO.builder().code(500).fecha(OffsetDateTime.now()).traceId(MDC.get("traceId").toString()).body(e.getMessage()).build()).build();
    }
}

