package com.fiap.hackathon.healthmed.doctor_api.core.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static jakarta.persistence.TemporalType.DATE;
import static jakarta.persistence.TemporalType.TIME;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "date")
    @Temporal(DATE)
    private LocalDate date;

    @Column(name = "start_time", nullable = false)
    @Temporal(TIME)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    @Temporal(TIME)
    private LocalTime endTime;
}
