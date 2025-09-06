package uy.com.labanca.notificaciones.application.dto.response;

import com.mercadopago.resources.ResultsPaging;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResultsGenericDTO {
    private ResultsPaging paging;
    private List<Object> results;
}
