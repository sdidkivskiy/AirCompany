package com.demo.aircompany.repository;

import com.demo.aircompany.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    Airplane findByName(String name);

}
