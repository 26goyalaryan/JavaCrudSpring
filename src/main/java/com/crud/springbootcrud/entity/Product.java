package com.crud.springbootcrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @NotNull(message = "Name can't be Null.")
    private String name;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "Enter a Positive Value.")
    private double price;
    @Min(value = 1, message = "Minimum Quantity should be 1.")
    private int quantity;
}
