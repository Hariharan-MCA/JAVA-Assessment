package com.assessment.Restful.API.Entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Email(message = "Invalid Email !")
    @Column(name = "email")
    @Length(max = 50, message = "Email must be less than 50 Characters")
    private String email;


    @Length(min = 3, message = "First Name must be 3 or more than 3 Characters")
    @Length(max = 20, message = "First Name must be less than 50 Characters")
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @Length(min = 3, message = "Last Name must be 3 or more than 3 Characters")
    @Length(max = 50, message = "Last Name must be less than 50 Characters")
    private String lastName;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 50, message = "Age should not be greater than 50")
    @Column(name = "age", nullable = false)
    private int age;
}
