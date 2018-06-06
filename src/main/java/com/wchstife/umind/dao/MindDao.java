package com.wchstife.umind.dao;

import com.wchstife.umind.entity.Mind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MindDao extends JpaRepository<Mind, String>{
}
