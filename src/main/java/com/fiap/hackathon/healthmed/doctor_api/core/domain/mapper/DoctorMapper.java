package com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor doctorCreateRequestToDoctor(DoctorCreateRequest request);

    DoctorResponse doctorToDoctorResponse(Doctor doctor);

    List<DoctorResponse> doctorListToDoctorResponseList(List<Doctor> doctors);

}
