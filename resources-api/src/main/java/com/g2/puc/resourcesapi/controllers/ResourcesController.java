package com.g2.puc.resourcesapi.controllers;

import com.g2.puc.resourcesapi.models.Detail;
import com.g2.puc.resourcesapi.models.Resource;
import com.g2.puc.resourcesapi.repositories.DetailsRepository;
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

    @Autowired
    private DetailsRepository detailsRepository;

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
    public ResponseEntity<Resource> createResource(@RequestBody List<Resource> resource){
        resourcesRepository.saveAll(resource);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path= "/details")
    public ResponseEntity<Resource> createResourceDetails(@RequestBody List<Detail> details){
        detailsRepository.saveAll(details);
        return new ResponseEntity(details, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<String> deleteResourceById(@PathVariable Long id){
        resourcesRepository.deleteById(id);
        return new ResponseEntity("Resource deleted.", HttpStatus.OK);
    }
}