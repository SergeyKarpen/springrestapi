package com.karpen.springRestApi.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


}
