package com.mftplus.workExperience.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity(name = "personEntity")
@Table(name = "persons")

@SQLDelete(sql = "UPDATE persons SET deleted=true WHERE id=?")
@SQLRestriction("deleted=false")

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid firstName")
    @Column(name = "firstName", nullable = false, length = 30)
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid lastName")
    @Column(name = "lastName", nullable = false, length = 30)
    private String lastName;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

}
