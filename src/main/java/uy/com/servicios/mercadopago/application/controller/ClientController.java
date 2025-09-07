package uy.com.servicios.mercadopago.application.controller;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.MDC;
import uy.com.servicios.mercadopago.application.dto.ClienteDTO;
import uy.com.servicios.mercadopago.application.dto.response.GenericResponseBody;
import uy.com.servicios.mercadopago.domain.service.CustomerService;

import jakarta.inject.Inject;

import java.time.OffsetDateTime;

@ApplicationScoped
@Path("/rest/customer")
public class ClientController {
    @Inject
    CustomerService service;


    @Path("/search")
    @GET
    public Response search(@QueryParam("email") String email) throws MPException, MPApiException{
        return Response.status(200).entity(GenericResponseBody.builder()
                .body(service.search(email))
                .fecha(OffsetDateTime.now())
                .traceId(MDC.get("traceId").toString())
                .code(0)
                .build()).build();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") String id)  throws MPException, MPApiException{
        return Response.status(200).entity(GenericResponseBody.builder()
                .body(service.find(id))
                .fecha(OffsetDateTime.now())
                .traceId(MDC.get("traceId").toString())
                .code(0)
                .build()).build();
    }



    @POST
    public Response create(@RequestBody ClienteDTO dto) throws MPException, MPApiException {
        return Response.status(201).entity(GenericResponseBody.builder()
                .body(service.create(dto))
                        .fecha(OffsetDateTime.now())
                        .traceId(MDC.get("traceId").toString())
                        .code(0)
                        .build()).build();
    }

    @PUT
    public Response update(@RequestBody ClienteDTO dto) throws MPException, MPApiException{
        return Response.status(201).entity(GenericResponseBody.builder()
                .body(service.update(dto))
                .fecha(OffsetDateTime.now())
                .traceId(MDC.get("traceId").toString())
                .code(0)
                .build()).build();
    }

}
