package com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway;

import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.CreateDoctorScheduleRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Component
@FeignClient(value = "auth-api", url = "${feign.client.config.scheduling-api.service.url}")
public interface SchedulingApiClient {

    @RequestMapping(method = POST, value = "/doctors/{doctorId}")
    void createDoctor(@PathVariable UUID doctorId, @RequestBody List<CreateDoctorScheduleRequest> scheduleRequests);
}
