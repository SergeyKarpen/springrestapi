package com.karpen.springRestApi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account")
public class Account extends BaseEntity{

    @Column(name = "account_data")
    private String account_data;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatus account_status;

}
