package com.enviro.assessment.grad001.MundawuBaloyi;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    @NotBlank(message = "Client name is mandatory")
    @Size(max = 100, message = "Client name must not exceed 100 characters")
    private String clientName;

    public WasteCategory() {
    }

    public WasteCategory(String name, String description, String clientName) {
        this.name = name;
        this.description = description;
        this.clientName = clientName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}