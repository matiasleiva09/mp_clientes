package uy.com.labanca.notificaciones.application.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mercadopago.resources.common.Identification;
import com.mercadopago.resources.common.Phone;
import com.mercadopago.resources.customer.CustomerAddress;
import com.mercadopago.resources.customer.CustomerCard;
import com.mercadopago.resources.customer.CustomerDefaultAddress;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ClienteResponseDTO (String id,String email,
        String firstName, String lastName, Phone phone,
                                  Identification identification,
         String defaultAddress,
         CustomerDefaultAddress address,
         OffsetDateTime dateRegistered,
         String description,
         OffsetDateTime dateCreated,
         OffsetDateTime dateLastUpdated,
         Map<String, Object>metadata,
         String defaultCard,
         List<CustomerCard>cards,
         List<CustomerAddress> addresses,
         Boolean liveMode) {
}
