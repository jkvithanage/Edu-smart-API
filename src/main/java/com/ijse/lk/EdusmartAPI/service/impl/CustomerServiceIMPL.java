package com.ijse.lk.EdusmartAPI.service.impl;

import com.ijse.lk.EdusmartAPI.dto.CustomerDTO;
import com.ijse.lk.EdusmartAPI.entity.Customer;
import com.ijse.lk.EdusmartAPI.repo.CustomerRepo;
import com.ijse.lk.EdusmartAPI.service.CustomerService;
import com.ijse.lk.EdusmartAPI.util.IdCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private IdCreator idCreator;

    @Override
    public String saveCustomer(CustomerDTO dto) {
        Customer customer = new Customer(
                idCreator.createId(), dto.getName(), dto.getAddress(), dto.getSalary()
        );
        return customerRepo.save(customer).getId() + "- saved!";
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        Optional tempData = customerRepo.findById(id);
        if (tempData.isPresent()) {
            Customer c = (Customer) tempData.get();
            return new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> loadAllCustomers() {
        ArrayList<CustomerDTO> dtoArrayList = new ArrayList<>();
        customerRepo.findAll().forEach(e -> {
            dtoArrayList.add(
                    new CustomerDTO(e.getId(), e.getName(), e.getAddress(), e.getSalary())
            );
        });
        return dtoArrayList;
    }

    @Override
    public String deleteCustomer(String id) {
        customerRepo.deleteById(id);
        return id + " - Deleted!";
    }

    @Override
    public String updateCustomer(CustomerDTO dto) {
        Optional<Customer> id = customerRepo.findById(dto.getId());
        if (id.isPresent()){
            Customer customer = id.get();
            customer.setName(dto.getName());
            customer.setAddress(dto.getAddress());
            customer.setSalary(dto.getSalary());
            return customerRepo.save(customer).getId()+" - Updated!";
        }else {
            return "Empty Result!";
        }
    }
}
