package com.backend.mytask.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.backend.mytask.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	@Query(value = "select * FROM userdb.user WHERE email=?", nativeQuery = true)
	User getUserByEmail(String email);
}
