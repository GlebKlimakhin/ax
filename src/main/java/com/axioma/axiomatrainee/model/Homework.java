package com.axioma.axiomatrainee.model;

import com.axioma.axiomatrainee.model.exercises.Exercise;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "homeworks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @NotNull
    Group group;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(name ="homeworks_exercises",
            joinColumns = @JoinColumn(name = "homework_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    Set<Exercise> exercises;
}
