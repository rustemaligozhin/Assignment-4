package com.finctonrol.financialcontrol.repositories;

import com.finctonrol.financialcontrol.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByUsername(String username);
    UserEntity getByUsername(String username);

}

