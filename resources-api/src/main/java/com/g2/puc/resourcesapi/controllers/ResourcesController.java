package com.g2.puc.resourcesapi.controllers;

import com.g2.puc.resourcesapi.models.Detail;
import com.g2.puc.resourcesapi.models.Resource;
import com.g2.puc.resourcesapi.models.ResourceType;
import com.g2.puc.resourcesapi.repositories.DetailsRepository;
import com.g2.puc.resourcesapi.repositories.ResourcesRepository;
import com.g2.puc.resourcesapi.services.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resourcesList = resourcesService.getAllResources();
        return new ResponseEntity(resourcesList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        try {
            return new ResponseEntity(resourcesService.findResourceById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No resource with given identifier found.", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<String> createResource(@RequestBody List<Resource> resources) {
        resourcesService.saveAllResources(resources);
        return new ResponseEntity("Resources created successfully.", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/type")
    public ResponseEntity<String> createResourceType(@RequestBody ResourceType resourceType) {
        resourcesService.saveResourceType(resourceType);
        return new ResponseEntity("Resource type created successfully.", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/type")
    public ResponseEntity<List<ResourceType>> getAllResourcesTypes() {
        List<ResourceType> resourcesList = resourcesService.getAllResourcesType();
        return new ResponseEntity(resourcesList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/details")
    public ResponseEntity<Resource> createResourceDetails(@RequestBody List<Detail> details) {
        resourcesService.createOrUpdateDetails(details);
        return new ResponseEntity(details, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<String> deleteResourceById(@PathVariable Long id) {
        try {
            resourcesService.deleteResourceById(id);
            return new ResponseEntity("Resource deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No resource with given identifier found.", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<String> updateResource(@RequestBody Resource resource) {
        resourcesService.updateResource(resource);
        return new ResponseEntity("Resource updated successfully.", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PatchMapping(path = "/details")
    public ResponseEntity<String> updateResourceDetails(@RequestBody List<Detail> details) {
        resourcesService.createOrUpdateDetails(details);
        return new ResponseEntity("Resource details updated.", HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<Resource>> getResourcesBySearchParams(
            @RequestParam(value = "resource_type") Long resourceType,
            @RequestParam(required = false) String description) {
        List<Resource> resources = resourcesService.findBySearchParams(resourceType, description);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}