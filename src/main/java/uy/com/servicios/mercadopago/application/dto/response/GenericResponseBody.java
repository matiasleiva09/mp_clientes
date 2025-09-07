package uy.com.servicios.mercadopago.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
public class GenericResponseBody<T>{
    private OffsetDateTime fecha;
    private int code;
    private T body;
    @JsonProperty("trace_id")
    private String traceId;
}
