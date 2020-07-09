package com.resliv.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City extends BaseEntity {

    @Column(name = "city_name", unique = true)
    private String cityName;

    @Column(name = "description")
    private String description;
}
