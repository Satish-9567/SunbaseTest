package com.example.SunBase.Service;

import com.example.SunBase.Repository.CustomerRepository;
import com.example.SunBase.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    public String addCustomer(String f_name, String l_name, String address, String city, String state, String email, String phone) {
//        Customer customer = new Customer();
//        customer.setFirst_name(f_name);
//        customer.setLast_name(l_name);
//        customer.setAddress(address);
//        customer.setCity(city);
//        customer.setState(state);
//        customer.setEmail(email);
//        customer.setPhone(phone);
//        customer=customerRepository.save(customer);
//        return "Customer added";
//    }
    public String addCustomer(Customer customer){
        customer=customerRepository.save(customer);
        return "Customer added";
    }

    public void updateCustomer(Integer customerId, String f_name, String l_name, String address, String city, String state, String email, String phone) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirst_name(f_name);
            customer.setLast_name(l_name);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setState(state);
            customer.setEmail(email);
            customer.setPhone(phone);
            customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
    }

    public Customer getCustomer(Integer customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }
    public void deleteCustomer(Integer customerId){
        customerRepository.deleteById(customerId);
    }
}
