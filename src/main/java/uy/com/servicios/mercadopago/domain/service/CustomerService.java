package uy.com.servicios.mercadopago.domain.service;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import uy.com.servicios.mercadopago.application.dto.ClienteDTO;
import uy.com.servicios.mercadopago.application.dto.response.ClienteResponseDTO;
import uy.com.servicios.mercadopago.application.dto.response.ResultsGenericDTO;

public interface CustomerService {
    ClienteResponseDTO create(ClienteDTO client) throws MPApiException, MPException;
    ClienteResponseDTO update(ClienteDTO client) throws MPApiException, MPException;
    ClienteResponseDTO find(String id) throws MPApiException, MPException;
    ResultsGenericDTO search(String email) throws MPApiException, MPException;
    void config();
}
