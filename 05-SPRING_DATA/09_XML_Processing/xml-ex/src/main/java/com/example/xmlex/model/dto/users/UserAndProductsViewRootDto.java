package com.example.xmlex.model.dto.users;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndProductsViewRootDto {

    @XmlAttribute(name = "count")
    private Integer count;
    @XmlElement(name = "user")
    private List<UserInfoDto> users;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserInfoDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfoDto> users) {
        this.users = users;
    }
}
