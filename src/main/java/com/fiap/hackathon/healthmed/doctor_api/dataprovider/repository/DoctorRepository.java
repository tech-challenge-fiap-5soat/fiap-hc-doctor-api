package com.fiap.hackathon.healthmed.doctor_api.dataprovider.repository;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
