package uy.com.labanca.notificaciones.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.HashMap;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ClienteDTO(String id,@Email String email, @NotNull @NotBlank String firstName, @NotNull @NotBlank String lastName, PhoneClientDTO phone,
                         IdentificationClientDTO identification, String defaultAddress, AddressClientDTO address, OffsetDateTime dateRegistred,
                         String description, String defaultCard, HashMap<String,Object> metadata) {
}
