package com.ijse.lk.EdusmartAPI.api;

import com.ijse.lk.EdusmartAPI.dto.CustomerDTO;
import com.ijse.lk.EdusmartAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/admin/member")
    public String saveCustomer(
            @RequestBody CustomerDTO dto
    ) {
        return customerService.saveCustomer(dto);
    }

    @DeleteMapping(path = "admin/member")
    public String deleteCustomer(@RequestParam(required = true) String id) {
        return customerService.deleteCustomer(id);
    }

    @PutMapping(path = "admin/member")
    public String updateCustomer(@RequestBody(required = true) CustomerDTO dto) {
        return customerService.updateCustomer(dto);
    }

    @GetMapping(path = "admin/member")
    public String getCustomer(@RequestParam(required = true) String id) {
        CustomerDTO dto = customerService.getCustomer(id);
        if (dto != null){
            return dto.toString();
        } else {
            return "Empty Result!";
        }
    }

    @GetMapping(path = "admin/member/list")
    public ArrayList<CustomerDTO> getAllCustomers() {
        return customerService.loadAllCustomers();
    }
}
