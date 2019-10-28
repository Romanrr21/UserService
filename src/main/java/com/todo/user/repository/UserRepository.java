package com.todo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.todo.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QueryByExampleExecutor<User> {
	
}
