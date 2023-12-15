package com.final_task.dealership.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.hibernate.Hibernate;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
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
@Table(name = "CUSTOMER", indexes = {
    @Index(columnList = "email", name = "user_email_idx")
})
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    private String id;

    @Column(name = "email", nullable = false, length = 80)
    private String email;

    @Column(name = "brand_preferences", nullable = false, length = 50)
    private String brandPreferences;

    @Column(name = "financial_capabilities", nullable = false)
    private BigDecimal  financialCapabilities;

    @ManyToOne(optional = false)
    private TechSpecifications techSpecifications;
}
