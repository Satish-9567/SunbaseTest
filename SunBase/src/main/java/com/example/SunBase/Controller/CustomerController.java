package com.example.SunBase.Controller;

import com.example.SunBase.Service.CustomerService;
import com.example.SunBase.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    //https//localhost:8080/home/add
//    @PostMapping("/add")
//    public String addCustomer(@RequestParam("f_name") String f_name,
//                            @RequestParam("l_name") String l_name,
//                            @RequestParam("address") String address,
//                            @RequestParam("city") String city,
//                            @RequestParam("state") String state,
//                            @RequestParam("email") String email,
//                            @RequestParam("phone") String phone) {
//        String result=customerService.addCustomer(f_name, l_name, address, city, state, email, phone);
//        return result;
//    }
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        String result=customerService.addCustomer(customer);
        return result;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/list")
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    // Implement updateCustomer endpoint
    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId,
                               @RequestParam("f_name") String f_name,
                               @RequestParam("l_name") String l_name,
                               @RequestParam("address") String address,
                               @RequestParam("city") String city,
                               @RequestParam("state") String state,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone) {
        customerService.updateCustomer(customerId, f_name, l_name, address, city, state, email, phone);
    }

    // Implement deleteCustomer endpoint
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId) {
        // Implement delete customer logic here
        customerService.deleteCustomer(customerId);
    }
}
