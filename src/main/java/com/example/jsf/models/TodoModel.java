package com.example.jsf.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String todoItem;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_model_id")
    private UserModel userModel;

}
