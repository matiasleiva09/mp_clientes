package uy.com.servicios.mercadopago.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AddressClientDTO (String id,String zipCode, String streetName,String streetNumber, String city){
}
