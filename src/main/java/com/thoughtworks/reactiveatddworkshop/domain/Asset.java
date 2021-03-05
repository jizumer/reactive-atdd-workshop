package com.thoughtworks.reactiveatddworkshop.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("assets")
public class Asset {
    @Id
    private String id;
    private String name;
    private Double amount;
}
