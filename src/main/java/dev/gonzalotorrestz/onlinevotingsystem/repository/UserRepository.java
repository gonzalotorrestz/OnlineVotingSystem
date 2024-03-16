package dev.gonzalotorrestz.onlinevotingsystem.repository;

import dev.gonzalotorrestz.onlinevotingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
