package com.senac.erick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.erick.entity.Role;
import com.senac.erick.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleName name);
}
