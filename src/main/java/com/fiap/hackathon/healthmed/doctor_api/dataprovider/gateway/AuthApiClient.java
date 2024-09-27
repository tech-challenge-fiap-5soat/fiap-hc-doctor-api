package com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway;

import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.CreateDoctorCredentialsRequest;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Component
@FeignClient(value = "auth-api", url = "${feign.client.config.auth-api.service.url}")
public interface AuthApiClient {

    @RequestMapping(method = POST, value = "/credentials")
    Boolean createCredentials(@RequestBody CreateDoctorCredentialsRequest request);

    @RequestMapping(method = POST, value = "/authorization")
    String login(@RequestBody LoginRequest request);

}
