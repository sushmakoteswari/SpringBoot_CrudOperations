package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.MyItemsList;


@Repository
public interface MyItemsRepository  extends JpaRepository<MyItemsList,Integer>{

}
