package com.g2.puc.resourcesapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Detail")
public class Detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="resource_id", nullable=false)
    private Resource resource;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Resource getResource() {
        return this.resource;
    }

    public void setId() {
        this.id = id;
    }

    public void setName() {
        this.name = name;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Detail(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Detail() {}

    public Detail(Long id, String name, Resource resource) {
        this.id = id;
        this.name = name;
        this.resource = resource;
    }
}
