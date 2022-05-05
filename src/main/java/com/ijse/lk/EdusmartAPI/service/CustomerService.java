package com.ijse.lk.EdusmartAPI.service;

import com.ijse.lk.EdusmartAPI.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public String saveCustomer(CustomerDTO dto);
    public CustomerDTO getCustomer(String id);
    public ArrayList<CustomerDTO> loadAllCustomers();
}
