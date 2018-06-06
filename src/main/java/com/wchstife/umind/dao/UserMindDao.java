package com.wchstife.umind.dao;

import com.wchstife.umind.entity.UserMind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMindDao extends JpaRepository<UserMind, String>{
}
