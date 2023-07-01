package com.upc.modelhouse.security.mapping;

import com.upc.modelhouse.security.domain.model.entity.BusinessProfile;
import com.upc.modelhouse.security.domain.model.entity.UserProfile;
import com.upc.modelhouse.security.resource.BusinessProfile.BusinessProfileDto;
import com.upc.modelhouse.security.resource.BusinessProfile.CreateBusinessProfileDto;
import com.upc.modelhouse.security.resource.BusinessProfile.UpdateBusinessProfileDto;
import com.upc.modelhouse.security.resource.UserProfile.UserProfileDto;
import com.upc.modelhouse.shared.mapping.EnhancedModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class BusinessProfileMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public BusinessProfileDto toResource(BusinessProfile model){
        return mapper.map(model, BusinessProfileDto.class);
    }
    public List<BusinessProfileDto> listToResource(List<BusinessProfile> model){
        return mapper.mapList(model, BusinessProfileDto.class);
    }
    public BusinessProfile toModel(BusinessProfileDto resource) {
        return mapper.map(resource, BusinessProfile.class);
    }

    public BusinessProfile toModel(CreateBusinessProfileDto resource) {
        return mapper.map(resource, BusinessProfile.class);
    }

    public BusinessProfile toModel(UpdateBusinessProfileDto resource) {
        return mapper.map(resource, BusinessProfile.class);
    }
}
