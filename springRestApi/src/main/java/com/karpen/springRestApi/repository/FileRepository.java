package com.karpen.springRestApi.repository;

import com.karpen.springRestApi.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
