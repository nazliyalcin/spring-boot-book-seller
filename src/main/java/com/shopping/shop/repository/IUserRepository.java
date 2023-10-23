package com.shopping.shop.repository;

import com.shopping.shop.model.Role;
import com.shopping.shop.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.function.Function;

public interface IUserRepository extends JpaRepository<User,Long>{


    Optional<User> findByUserName(String userName);

    @Modifying
    @Query("update User set role = :role where userName = :userName")
    void updateUserRole(@Param("userName") String userName, @Param("role") Role role);


}
