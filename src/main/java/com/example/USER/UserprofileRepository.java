package com.example.USER;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserprofileRepository extends JpaRepository<User, Long> {

}
