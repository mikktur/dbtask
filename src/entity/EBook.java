package entity;

import jakarta.persistence.Entity;

@Entity
public class EBook extends Book {
    private String downloadLink;

    // Getters and Setters
}