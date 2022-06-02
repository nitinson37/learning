package de.mobile.controller;

import de.mobile.model.Ad;
import de.mobile.model.Customer;
import de.mobile.service.AdService;
import de.mobile.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("customer")
public class CustomerResource {

    private final CustomerService customerService;

    @Inject
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer get(@PathVariable("id") Long customerId) {
        return customerService.get(customerId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> list() {
        return customerService.list();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Long addAd(@Valid @RequestBody Customer customer) {
        return customerService.create(customer);
    }
}
