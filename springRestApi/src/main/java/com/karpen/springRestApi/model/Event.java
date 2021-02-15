package com.karpen.springRestApi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "event")
public class Event extends BaseEntity {

    @Column(name = "name_event")
    private String event_name;

    @Column(name = "file_id")
    @JoinColumn(name = "id")
    private Long file_id;

}
