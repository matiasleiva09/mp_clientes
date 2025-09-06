package uy.com.labanca.notificaciones.infrastructure.excepcion.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import com.mercadopago.exceptions.MPApiException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.SneakyThrows;
import org.jboss.logging.MDC;
import uy.com.labanca.notificaciones.infrastructure.excepcion.ErrorDTO;

import java.time.Instant;
import java.time.OffsetDateTime;

@Provider
public class ExternarlMPApiExceptionMapper  implements ExceptionMapper<MPApiException> {
    @Inject
    ObjectMapper mapper;
    @SneakyThrows
    @Override
    public Response toResponse(MPApiException e) {
        return Response.status(e.getStatusCode())
                .entity(ErrorDTO
                        .builder()
                        .code(e.getStatusCode())
                        .fecha(OffsetDateTime.now()).traceId(MDC.get("traceId").toString())
                        .body(mapper.readTree(e.getApiResponse().getContent())).build()).build();
    }
}
