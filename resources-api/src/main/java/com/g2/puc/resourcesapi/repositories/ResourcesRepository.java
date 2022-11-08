package com.g2.puc.resourcesapi.repositories;

import com.g2.puc.resourcesapi.models.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResourcesRepository extends JpaRepository<Resource, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM RESOURCE WHERE RESOURCE_TYPE_ID = :resourceTypeId")
    public List<Resource> findAllByResourceType(Long resourceTypeId);

    @Query(nativeQuery = true, value = "SELECT * FROM RESOURCE WHERE DESCRIPTION LIKE %:description% AND RESOURCE_TYPE_ID = :resourceTypeId")
    public List<Resource> findAllByDescription(String description, Long resourceTypeId);


}