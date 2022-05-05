package com.ijse.lk.EdusmartAPI.repo;

import com.ijse.lk.EdusmartAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
}
