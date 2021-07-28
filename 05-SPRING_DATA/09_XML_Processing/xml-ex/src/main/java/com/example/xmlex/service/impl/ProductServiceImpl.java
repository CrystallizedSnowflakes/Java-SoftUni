package com.example.xmlex.service.impl;

import com.example.xmlex.model.dto.seed.ProductSeedDto;
import com.example.xmlex.model.dto.inRange.ProductViewRootDto;
import com.example.xmlex.model.dto.inRange.ProductWithSellerDto;
import com.example.xmlex.model.entity.Product;
import com.example.xmlex.repository.ProductRepository;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.service.ProductService;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public long getEntityCount() {
        return this.productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products
                .stream()
                .filter(this.validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = this.modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(this.userService.getRandomUser());
                    if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
                        product.setBuyer(this.userService.getRandomUser());
                    }
                    product.setCategories(this.categoryService.getRandomCategories());
                    return product;
                })
                .forEach(this.productRepository::save);
    }

    @Override
    public ProductViewRootDto findProductsInRangeWithNoBuyer() {
        ProductViewRootDto productViewRootDto = new ProductViewRootDto();
        productViewRootDto
                .setProducts(this.productRepository
                    .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                    .stream()
                    .map(product -> {
                        ProductWithSellerDto productWithSellerDto = this.modelMapper.map(product, ProductWithSellerDto.class);
                        productWithSellerDto.setSeller(String.format("%s %s",
                                product.getSeller().getFirstName() == null ? "GDPR" : product.getSeller().getFirstName(),
                                product.getSeller().getLastName()));
                        return productWithSellerDto;
                    })
                    .collect(Collectors.toList()));

        return productViewRootDto;
    }

}
