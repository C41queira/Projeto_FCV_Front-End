package com.projetofcv.rosangelaestetica.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetofcv.rosangelaestetica.entity.enums.CategoryWork;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_work")
public class Work implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name; 
    @Enumerated(EnumType.STRING)
    private CategoryWork categoryWork; 
    private String info;
    private Double price; 

    @ManyToOne
    @JoinColumn(name = "id_agenda")
    @JsonIgnore
    private Agenda agendaWorks; 
    
    public Work() {
    }

    public Work(Long id, String name, CategoryWork categoryWork, String info, Double price, Agenda agenda) {
        this.id = id;
        this.name = name;
        this.categoryWork = categoryWork;
        this.info = info;
        this.price = price; 
        this.agendaWorks = agenda; 
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

    public CategoryWork getCategoryWork() {
        return categoryWork;
    }

    public void setCategoryWork(CategoryWork categoryWork) {
        this.categoryWork = categoryWork;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    } 


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Work other = (Work) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
