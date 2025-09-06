package uy.com.labanca.notificaciones.infrastructure.excepcion.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import uy.com.labanca.notificaciones.infrastructure.excepcion.BadRequestException;
import uy.com.labanca.notificaciones.infrastructure.excepcion.ErrorDTO;
import org.jboss.logging.MDC;
import java.time.Instant;
import java.time.OffsetDateTime;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException e) {
        return Response.status(400).entity(ErrorDTO.builder().code(400).fecha(OffsetDateTime.now()).traceId(MDC.get("traceId").toString()).body(e.getMessage()).build()).build();
    }
}
