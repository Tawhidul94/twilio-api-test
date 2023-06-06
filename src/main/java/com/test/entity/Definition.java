package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Definition {

    @Id
    @Column(name = "def", nullable = false)
    private String def;

    @Column(name = "word", nullable = false)
    private String name;


}
