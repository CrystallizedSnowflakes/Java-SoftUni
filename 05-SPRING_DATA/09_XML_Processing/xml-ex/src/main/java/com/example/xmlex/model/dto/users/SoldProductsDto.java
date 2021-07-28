package com.example.xmlex.model.dto.users;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsDto {

    @XmlAttribute(name = "count")
    private Integer productCount;
    @XmlElement(name = "product")
    private List<ProductInfoDto> products;

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public List<ProductInfoDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInfoDto> products) {
        this.products = products;
    }
}
