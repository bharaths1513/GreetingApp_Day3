package com.example.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Demo.model.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long>  {

}
