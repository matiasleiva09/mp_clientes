package uy.com.servicios.mercadopago.infrastructure.mapper;

import com.mercadopago.client.customer.CustomerRequest;
import com.mercadopago.resources.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import uy.com.servicios.mercadopago.application.dto.ClienteDTO;
import uy.com.servicios.mercadopago.application.dto.response.ClienteResponseDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface MapperCustomer {
     CustomerRequest to (ClienteDTO dto);
     ClienteResponseDTO to (Customer obj);
     //ResultsGenericDTO to (MPResultsResourcesPage<Customer> list);
}
