package com.demo.aircompany.repository;

import com.demo.aircompany.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {

    AirCompany findByName(String name);

}
