package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.SkinCare;

@Repository
public interface MartRepository extends JpaRepository<SkinCare, Integer> {

}
