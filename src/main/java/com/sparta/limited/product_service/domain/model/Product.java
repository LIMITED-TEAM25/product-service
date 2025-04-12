package com.sparta.limited.product_service.domain.model;

import com.sparta.limited.common_module.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_product")
@SQLRestriction("deleted_at IS Null")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    private Product(String title, String description, BigDecimal price) {
        super(1L); // 임시
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public static Product of(String title, String description, BigDecimal price) {
        return new Product(title, description, price);
    }

    public void update(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

}
