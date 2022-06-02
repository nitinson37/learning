package de.mobile.repository;

import de.mobile.entity.MobileCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<MobileCustomer, Long> {

}
