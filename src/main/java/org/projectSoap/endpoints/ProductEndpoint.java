package org.projectSoap.endpoints;

import lombok.RequiredArgsConstructor;
import org.projectSoap.service.ProductService;
import org.projectSoap.soap.products.GetProductByTitleRequest;
import org.projectSoap.soap.products.GetProductByTitleResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.flamexander.com/spring/ws/products";
    private final ProductService productService;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByTitleRequest")
    @ResponsePayload
    public GetProductByTitleResponse getProductByTitleResponse(@RequestPayload GetProductByTitleRequest request) {
        GetProductByTitleResponse response = new GetProductByTitleResponse();
        response.setProduct(productService.getByTitle(request.getTitle()));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProductsResponse(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        productService.getAllProducts().forEach(response.getProducts()::add);
        return response;
    }
}
