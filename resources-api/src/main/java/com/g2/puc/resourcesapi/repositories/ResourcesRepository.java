package com.g2.puc.resourcesapi.repositories;

import com.g2.puc.resourcesapi.models.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResourcesRepository extends JpaRepository<Resource, Long> {

}