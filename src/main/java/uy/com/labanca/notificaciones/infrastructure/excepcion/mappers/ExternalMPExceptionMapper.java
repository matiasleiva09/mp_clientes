package uy.com.labanca.notificaciones.infrastructure.excepcion.mappers;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.MDC;
import uy.com.labanca.notificaciones.infrastructure.excepcion.ErrorDTO;

import java.time.Instant;
import java.time.OffsetDateTime;

@Provider
public class ExternalMPExceptionMapper implements ExceptionMapper<MPException> {
    @Override
    public Response toResponse(MPException e) {
        return Response.status(400).entity(ErrorDTO.builder().code(400).fecha(OffsetDateTime.now()).traceId(MDC.get("traceId").toString()).body(e.getMessage()).build()).build();
    }
}
