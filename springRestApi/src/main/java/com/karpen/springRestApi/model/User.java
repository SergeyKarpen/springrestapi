package com.karpen.springRestApi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @ManyToMany
    @JoinColumn(name = "id")
    private List<Event> eventList;

    @ManyToMany
    @JoinColumn(name = "id")
    private List<File> fileList;

    @OneToOne
    private Account account;

}
