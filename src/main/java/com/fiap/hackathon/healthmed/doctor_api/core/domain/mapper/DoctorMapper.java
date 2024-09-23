package com.fiap.hackathon.healthmed.doctor_api.core.domain.mapper;

import com.fiap.hackathon.healthmed.doctor_api.common.enums.UserAuthType;
import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import com.fiap.hackathon.healthmed.doctor_api.dataprovider.gateway.request.CreateDoctorCredentialsRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.request.DoctorCreateRequest;
import com.fiap.hackathon.healthmed.doctor_api.entrypoint.controller.payload.response.DoctorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.EnumSet;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor doctorCreateRequestToDoctor(DoctorCreateRequest request);

    DoctorResponse doctorToDoctorResponse(Doctor doctor);

    List<DoctorResponse> doctorListToDoctorResponseList(List<Doctor> doctors);

    @Mapping(target = "userType", qualifiedByName = "enumFieldMapping")
    CreateDoctorCredentialsRequest doctorToCreateDoctorCredentialsRequest(Doctor doctor);

    @Named("enumFieldMapping")
    default UserAuthType enumFieldMapping(String sourceEnumField) {
        if (sourceEnumField != null && !sourceEnumField.isEmpty()) {
            return UserAuthType.valueOf(sourceEnumField.toUpperCase());
        } else {
            return UserAuthType.DOCTOR;
        }
    }
}
