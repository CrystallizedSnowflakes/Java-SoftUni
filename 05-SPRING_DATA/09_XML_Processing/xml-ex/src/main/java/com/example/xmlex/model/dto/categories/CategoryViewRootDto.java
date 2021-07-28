package com.example.xmlex.model.dto.categories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryViewRootDto {

    @XmlElement(name = "category")
    private List<CategoryInfoDto> categories;


    public List<CategoryInfoDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryInfoDto> categories) {
        this.categories = categories;
    }
}
