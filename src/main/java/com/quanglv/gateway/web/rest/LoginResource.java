package com.quanglv.gateway.web.rest;

import com.quanglv.gateway.config.DomainConfig;
import com.quanglv.gateway.config.restTemplate.ConstantsTemplate;
import com.quanglv.gateway.config.restTemplate.RestOperationsUtils;
import com.quanglv.gateway.service.dto.GetTokenResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResource {
    @Autowired
    private DomainConfig domainConfig;

    @Autowired
    private RestOperationsUtils restOperationsUtils;

    @PostMapping(value = "/get-token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getToken(){
        String apiName = "authorization/oauth/token?grant_type=password&username=admin&password=123456&scope=trust";
        GetTokenResponseDTO response = restOperationsUtils.executeGetToken(domainConfig.getAuthorizationDomain(), apiName, ConstantsTemplate.httpMethod_POST, null, GetTokenResponseDTO.class);
        return ResponseEntity.ok(response);
    }
}