package com.g2.puc.resourcesapi.services;

import com.g2.puc.resourcesapi.models.Detail;
import com.g2.puc.resourcesapi.models.Resource;
import com.g2.puc.resourcesapi.models.ResourceType;
import com.g2.puc.resourcesapi.repositories.DetailsRepository;
import com.g2.puc.resourcesapi.repositories.ResourceTypeRepository;
import com.g2.puc.resourcesapi.repositories.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourcesService {

    @Autowired
    private DetailsRepository detailsRepository;

    @Autowired
    private ResourcesRepository resourcesRepository;

    @Autowired

    private ResourceTypeRepository resourceTypeRepository;

    public List<Resource> findBySearchParams(Long resourceType, String description) {
        if (description == null)
            return resourcesRepository.findAllByResourceType(resourceType);
        return resourcesRepository.findAllByDescription(description, resourceType);
    }

    public List<Resource> getAllResources() {
        return resourcesRepository.findAll();
    }

    public Resource findResourceById(Long id) {
        return resourcesRepository.findById(id).get();
    }

    public void saveAllResources(List<Resource> resources) {
        resourcesRepository.saveAll(resources);
    }

    public void createOrUpdateDetails(List<Detail> details) {
        detailsRepository.saveAll(details);
    }

    public void deleteResourceById(Long id) {
        resourcesRepository.deleteById(id);
    }

    public void updateResource(Resource resource) {
        resourcesRepository.save(resource);
    }

    public void saveResourceType(ResourceType resourceType) {
        resourceTypeRepository.save(resourceType);
    }

    public List<ResourceType> getAllResourcesType() {
        return resourceTypeRepository.findAll();
    }

}
