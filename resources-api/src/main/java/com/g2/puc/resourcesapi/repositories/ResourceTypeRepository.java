package com.g2.puc.resourcesapi.repositories;

import com.g2.puc.resourcesapi.models.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceTypeRepository extends JpaRepository<ResourceType, Long> {
}
