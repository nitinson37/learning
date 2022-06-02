package de.mobile.service;

import de.mobile.entity.MobileCustomer;
import de.mobile.exception.AdNotFoundException;
import de.mobile.model.Customer;
import de.mobile.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long create(Customer customerData) {
        MobileCustomer customer = inbound(customerData);
        return customerRepository.save(customer).getId();
    }

    public Customer get(Long customerId) {
        Optional<MobileCustomer> mobileCustomer = customerRepository.findById(customerId);
        if(!mobileCustomer.isPresent()){
            throw new AdNotFoundException("Customer not found. customerId = "+customerId);
        }
        return outbound(mobileCustomer.get());
    }

    public List<Customer> list() {

        List<Customer> adsList = new ArrayList<>();
        customerRepository.findAll()
                .forEach(mobileCustomer -> adsList.add(outbound(mobileCustomer)));

        return adsList;
    }

    private Customer outbound(MobileCustomer mobileCustomer) {
        Customer customerData = new Customer();
        customerData.setId(mobileCustomer.getId());
        customerData.setFirstName(mobileCustomer.getFirstName());
        customerData.setLastName(mobileCustomer.getLastName());
        customerData.setCompanyName(mobileCustomer.getCompanyName());
        customerData.setEmail(mobileCustomer.getEmail());
        return customerData;
    }

    private MobileCustomer inbound(Customer customerData) {
        MobileCustomer mobileCustomer = new MobileCustomer();
        mobileCustomer.setId(customerData.getId());
        mobileCustomer.setFirstName(customerData.getFirstName());
        mobileCustomer.setLastName(customerData.getLastName());
        mobileCustomer.setCompanyName(customerData.getCompanyName());
        mobileCustomer.setEmail(customerData.getEmail());
        return mobileCustomer;
    }

}
