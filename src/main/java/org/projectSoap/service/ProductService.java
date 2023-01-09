package org.projectSoap.service;

import lombok.RequiredArgsConstructor;
import org.projectSoap.entities.ProductEntity;
import org.projectSoap.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public final static Function<ProductEntity, Product> functionEntityToSoap = se -> {
        Product p = new Product();
        p.setProductId(se.getProductId());
        p.setProductTitle(se.getTitle());
        p.setPrice(se.getPrice());
        p.setCategory(se.getCategories().getCategoryTitle());
        return p;
    };

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Product getByTitle(String title) {
        return productRepository.findByName(title).map(functionEntityToSoap).get();
    }
}
