package uy.com.labanca.notificaciones.infrastructure.serviceimp;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.customer.CustomerClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.MPResultsResourcesPage;
import com.mercadopago.net.MPSearchRequest;
import com.mercadopago.resources.customer.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import uy.com.labanca.notificaciones.application.dto.ClienteDTO;
import uy.com.labanca.notificaciones.application.dto.response.ClienteResponseDTO;
import uy.com.labanca.notificaciones.application.dto.response.ResultsGenericDTO;
import uy.com.labanca.notificaciones.domain.service.CustomerService;
import uy.com.labanca.notificaciones.infrastructure.mapper.MapperCustomer;

import jakarta.inject.Inject;

import java.util.Collections;
import java.util.Map;

@ApplicationScoped
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerClient clientService = new CustomerClient();
    @Inject
    MapperCustomer mapper;

    @Override
    public ResultsGenericDTO search(String email) throws MPApiException, MPException{
        config();
      /*  return  mapper.to(clientService.search(MPSearchRequest.builder()
                .filters(Map.ofEntries(Map.entry("email",email)))
                .offset(0)
                .limit(10000)
                .build()));*/
        MPResultsResourcesPage<Customer> res = clientService.search(MPSearchRequest.builder()
                .filters(Map.ofEntries(Map.entry("email",email)))
                .offset(0)
                .limit(10000)
                .build());
        return ResultsGenericDTO.builder().results(Collections.singletonList(res.getResults())).paging(res.getPaging()).build();
    }

    @Override
    public ClienteResponseDTO find(String id) throws MPApiException, MPException{
        config();
        return mapper.to(clientService.get(id));
    }
    @Override
    public ClienteResponseDTO create(ClienteDTO client) throws MPApiException, MPException {
        config();
        return mapper.to(clientService.create(mapper.to(client)));
    }

    @Override
    public ClienteResponseDTO update(ClienteDTO client) throws MPApiException, MPException {
        config();
        return mapper.to(clientService.update(client.id(), mapper.to(client)));
    }

    @Override
    public void config() {
        MercadoPagoConfig.setAccessToken("APP_USR-5532466167425870-102707-5664f3e185ac0823a3df4a76d80d379b-1226247145");
    }
}
