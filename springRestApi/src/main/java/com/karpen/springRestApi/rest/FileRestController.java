package com.karpen.springRestApi.rest;

import com.karpen.springRestApi.model.File;
import com.karpen.springRestApi.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/karpen/api/")
public class FileRestController {

   private final FileService fileService;

   @Autowired
    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @ResponseBody
    @GetMapping(value = "/files")
    @PreAuthorize("hasAnyAuthority('user', 'moderator', 'admin')")
    public String findAll() {
        List<File> files = fileService.findAll();
        return files.toString();
    }

    @ResponseBody
    @GetMapping(value = "/file/{id}")
    @PreAuthorize("hasAnyAuthority('user', 'moderator', 'admin')")
    public String findById(@PathVariable("id") Long id) {
        return fileService.findById(id).toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/file-deleted/{id}")
    @PreAuthorize("hasAnyAuthority('admin', 'moderator')")
    public String deletedById (@PathVariable("id") Long id) {
        fileService.deletedById(id);
        return "deleted file with id = " + id;
    }

    @ResponseBody
    @PostMapping(value = "/file-save")
    @PreAuthorize("hasAnyAuthority('admin', 'moderator')")
    public String save (@RequestBody File file) {
        fileService.save(file);
        return "save file with id = " + file.getId();
    }

}
