package com.g2.puc.resourcesapi.repositories;

import com.g2.puc.resourcesapi.models.Detail;
import com.g2.puc.resourcesapi.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Detail, Long> {
}
