package com.freelance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private double price;

    public Service() {}

    public Service(String description, double price) {
        this.description = description;
        this.price = price;
    }
    
    public int getId() 
    { return id; 
    }
    public void setId(int id) 
    { this.id = id; 
    }
    public String getDescription() 
    { return description; 
    }
    public void setDescription(String description) 
    { this.description = description; 
    }
    public double getPrice() 
    { return price; 
    }
    public void setPrice(double price) 
    { this.price = price; 
    }
}

