package entity;

import jakarta.persistence.Entity;

@Entity
public class PrintedBook extends Book {
    private int pageCount;

    // Getters and Setters
}