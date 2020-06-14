package com.punojsoft.connectionpool.dbcpexample.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
