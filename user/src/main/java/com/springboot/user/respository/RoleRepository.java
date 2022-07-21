package com.springboot.user.respository;

import com.springboot.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Integer> {

}
