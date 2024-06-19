package com.example.BeASinger.repository;

import com.example.BeASinger.domain.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Integer> {}
