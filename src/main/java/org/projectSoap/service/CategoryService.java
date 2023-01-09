package org.projectSoap.service;

import lombok.RequiredArgsConstructor;
import org.projectSoap.entities.CategoryEntity;
import org.projectSoap.repositories.CategoryRepository;
import org.projectSoap.soap.categories.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public final static Function<CategoryEntity, Category> functionEntityToSoap = ce -> {
        Category c = new Category();
        c.setCategoryTitle(ce.getCategoryTitle());
        ce.setProducts().stream().map(ProductService.functionEntityToSoap).forEach(p -> c.getProducts().add(p));
        return c;
    };

    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Category getByTitle(String title) {
        return categoryRepository.findByTitle(title).map(functionEntityToSoap).get();
    }
}
