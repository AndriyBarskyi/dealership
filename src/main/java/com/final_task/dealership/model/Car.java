package com.final_task.dealership.model;

import java.math.BigDecimal;

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
@Table(name = "CAR", indexes = {
    @Index(columnList = "brand", name = "car_brand_idx")
})
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    private String id;

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "condition", nullable = false)
    private Condition condition;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "is_used", nullable = false)
    private boolean isUsed;

    @Column(name = "technical_specifications", nullable = false)
    private TechSpecifications technicalSpecifications;

    @Column(name = "other_features", nullable = false)
    private String otherFeatures;
}
