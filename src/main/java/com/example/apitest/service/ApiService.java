package com.example.apitest.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apitest.entity.ApiEntity;
import com.example.apitest.model.ApiModel;
import com.example.apitest.repository.ApiJpaRepository;

@Service
@Transactional
public class ApiService {

    @Autowired
    private ApiJpaRepository apiJpaRepository;

    // @Autowired
    // private ApiJdbcRepository apiJdbcrepository;

    public Object findAll() {
        return apiJpaRepository.findAll();
    }

    public String insert(ApiModel model) {
        ApiEntity entity = new ApiEntity();
        entity.setRequest_date(new Date());
        entity.setSsotype(model.getSsotype());
        entity.setSystemid(model.getSystemid());
        entity.setSystemname(model.getSystemname());
        entity.setSystemtransactions(model.getSystemtransactions());
        entity.setSystemprivileges(model.getSystemprivileges());
        entity.setSystemusergroup(model.getSystemusergroup());
        entity.setSystemlocationgroup(model.getSystemlocationgroup());
        entity.setUserid(model.getUserid());
        entity.setUserfullname(model.getUserfullname());
        entity.setUserrdofficecode(model.getUserrdofficecode());
        entity.setUserofficecode(model.getUserofficecode());
        entity.setClientlocation(model.getClientlocation());
        entity.setLocationmachinenumber(model.getLocationmachinenumber());
        entity.setTokenid(model.getTokenid());
        apiJpaRepository.save(entity);
        return "ok";
        
    }

}
