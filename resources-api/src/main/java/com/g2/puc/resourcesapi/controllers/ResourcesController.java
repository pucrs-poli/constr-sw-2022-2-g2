package com.g2.puc.resourcesapi.controllers;

import com.g2.puc.resourcesapi.models.Resource;
import com.g2.puc.resourcesapi.repositories.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    @Autowired
    private ResourcesRepository resourcesRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources(){
        List<Resource> resourcesList = resourcesRepository.findAll();
        return new ResponseEntity(resourcesList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id){
        return new ResponseEntity(resourcesRepository.findById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource){
        return new ResponseEntity(resource, HttpStatus.OK);
    }
}