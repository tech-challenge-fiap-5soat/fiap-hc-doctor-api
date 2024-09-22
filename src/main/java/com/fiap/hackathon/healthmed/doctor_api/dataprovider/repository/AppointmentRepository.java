package com.fiap.hackathon.healthmed.doctor_api.dataprovider.repository;

import com.fiap.hackathon.healthmed.doctor_api.core.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    @Query(value = "SELECT * FROM appointments a " +
            "WHERE a.doctor_id = :doctorId " +
            "AND (DATE(a.date) = :date AND a.start_time >= :startTime) " +
            "OR DATE(a.date) > :date " +
            "ORDER BY a.date, a.start_time",
            nativeQuery = true)
    List<Appointment> findAppointmentsByDoctorIdAndDateAndStartTime(
            @Param("doctorId") UUID doctorId,
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime);
}
