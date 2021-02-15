package com.karpen.springRestApi.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "file")
public class File extends BaseEntity {

    @Column(name="name_file")
    private String file_name;

    @Column(name = "uri_file")
    private String uri_file;

    @Enumerated(EnumType.STRING)
    @Column(name = "file_status")
    private FileStatus file_Status;

}
