package com.axioma.axiomatrainee.repository;

import com.axioma.axiomatrainee.model.Group;
import com.axioma.axiomatrainee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IGroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findByName(String name);

    List<Group> findAllByUsersContaining(User user);
}
