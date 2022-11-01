package com.g2.puc.resourcesapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Resource")
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String status;

    @ManyToOne
    @JoinColumn(name="resource_type_id", nullable=false)
    private ResourceType resourceType;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource", cascade = {CascadeType.MERGE, CascadeType.REFRESH}) //mappedBy= referenz attribute name in Offer
    private List<Detail> details;

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatus() {
        return this.status;
    }

    public ResourceType getResourceType() {
        return this.resourceType;
    }

    public List<Detail> getDetails() {
        return this.details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
