package com.upc.modelhouse.security.mapping;

import com.upc.modelhouse.security.domain.model.entity.Account;
import com.upc.modelhouse.security.resource.CreateUserResource;
import com.upc.modelhouse.security.resource.UserResource;
import com.upc.modelhouse.shared.mapping.EnhancedModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class UserMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public UserMapper userMapper() {
        return new UserMapper(modelMapper);
    }

    public Page<UserResource> modelListPage(List<UserResource> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

    public Account toModel(CreateUserResource resource) {
        return modelMapper.map(resource, Account.class);
    }

    public UserResource toResource(Account account) {
        return modelMapper.map(account, UserResource.class);
    }

}

