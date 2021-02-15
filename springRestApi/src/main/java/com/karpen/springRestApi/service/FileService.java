package com.karpen.springRestApi.service;

import com.karpen.springRestApi.model.File;
import com.karpen.springRestApi.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File findById(Long id) {
        return fileRepository.getOne(id);
    }

    public List<File> findAll() {
        return fileRepository.findAll();
    }

    public File save(File file) {
        return fileRepository.save(file);
    }

    public void deletedById(Long id) {
        fileRepository.deleteById(id);
    }
}
