package uy.com.labanca.notificaciones.domain.service;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.MPResultsResourcesPage;
import com.mercadopago.resources.customer.Customer;
import uy.com.labanca.notificaciones.application.dto.ClienteDTO;
import uy.com.labanca.notificaciones.application.dto.response.ClienteResponseDTO;
import uy.com.labanca.notificaciones.application.dto.response.ResultsGenericDTO;

public interface CustomerService {
    ClienteResponseDTO create(ClienteDTO client) throws MPApiException, MPException;
    ClienteResponseDTO update(ClienteDTO client) throws MPApiException, MPException;
    ClienteResponseDTO find(String id) throws MPApiException, MPException;
    ResultsGenericDTO search(String email) throws MPApiException, MPException;
    void config();
}
