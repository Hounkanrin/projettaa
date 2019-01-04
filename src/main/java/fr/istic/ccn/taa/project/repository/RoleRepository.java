package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleName);

}
