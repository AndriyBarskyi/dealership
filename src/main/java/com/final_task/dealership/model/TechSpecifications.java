package com.final_task.dealership.model;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TECH_SPECIFICATIONS")
@AllArgsConstructor
public class TechSpecifications {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    private String id;

    @Column(name = "color", nullable = false, length = 50)
    private Color color;

    @Column (name = "type", nullable = false)
    private Type type;

    @Column(name = "engine", nullable = false, length = 50)
    private String engine;

    @Column(name = "horsepower", nullable = false)
    private int horsepower;

    @Column(name = "top_speed", nullable = false)
    private int topSpeed;

    @Column(name = "fuel_consumption", nullable = false)
    private float fuelConsumption;
}
