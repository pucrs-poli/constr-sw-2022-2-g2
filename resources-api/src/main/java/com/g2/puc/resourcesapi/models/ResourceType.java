package com.g2.puc.resourcesapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="resource_type")
public class ResourceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "resourceType")
    private List<Resource> resources;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Resource> getResources() {
        return this.resources;
    }

    public ResourceType() {}

    public ResourceType(Long id, String name, List<Resource> resources) {
        this.id = id;
        this.name = name;
        this.resources = resources;
    }
}
