package uy.com.labanca.notificaciones.infrastructure.mapper;

import com.mercadopago.client.customer.CustomerRequest;
import com.mercadopago.net.MPResultsResourcesPage;
import com.mercadopago.resources.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import uy.com.labanca.notificaciones.application.dto.ClienteDTO;
import uy.com.labanca.notificaciones.application.dto.response.ClienteResponseDTO;
import uy.com.labanca.notificaciones.application.dto.response.ResultsGenericDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface MapperCustomer {
     CustomerRequest to (ClienteDTO dto);
     ClienteResponseDTO to (Customer obj);
     //ResultsGenericDTO to (MPResultsResourcesPage<Customer> list);
}
