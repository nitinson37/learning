package de.mobile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import de.mobile.entity.MobileCustomer;
import de.mobile.exception.AdNotFoundException;
import de.mobile.model.Ad;
import de.mobile.entity.MobileAd;
import de.mobile.model.Customer;
import de.mobile.repository.AdRepository;
import de.mobile.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdService {

    private static final Logger logger = LoggerFactory.getLogger(AdService.class);

    private final AdRepository adRepository;

    @Inject
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public Long create(Ad adData) {
        MobileAd ad = inbound(adData);
        return adRepository.save(ad).getId();
    }

    public Ad get(Long adId) {
        Optional<MobileAd> mobileAd = adRepository.findById(adId);
        if(!mobileAd.isPresent()){
            throw new AdNotFoundException("Ad not found. AdId = "+adId);
        }
        return outbound(mobileAd.get());
    }

    public List<Ad> list() {

        List<Ad> adsList = new ArrayList<>();
        adRepository.findAll()
                .forEach(mobileAd -> adsList.add(outbound(mobileAd)));

        return adsList;
    }

    private Ad outbound(MobileAd mobileAd) {
        Ad adData = new Ad();
        adData.setId(mobileAd.getId());
        adData.setCategory(mobileAd.getCategory());
        adData.setMake(mobileAd.getMake());
        adData.setModel(mobileAd.getModel());
        adData.setDescription(mobileAd.getDescription());
        adData.setPrice(mobileAd.getPrice());

        Customer customer = new Customer();
        customer.setId(mobileAd.getMobileCustomer().getId());
        customer.setFirstName(mobileAd.getMobileCustomer().getFirstName());
        customer.setLastName(mobileAd.getMobileCustomer().getLastName());
        customer.setCompanyName(mobileAd.getMobileCustomer().getCompanyName());
        customer.setEmail(mobileAd.getMobileCustomer().getEmail());

        adData.setCustomer(customer);
        return adData;
    }

    private MobileAd inbound(Ad adData) {
        MobileCustomer mobileCustomer = new MobileCustomer();
        MobileAd mobileAd = new MobileAd();
        mobileAd.setId(adData.getId());
        mobileAd.setCategory(adData.getCategory());
        mobileAd.setMake(adData.getMake());
        mobileAd.setModel(adData.getModel());
        mobileAd.setDescription(adData.getDescription());
        mobileAd.setPrice(adData.getPrice());

        mobileCustomer.setId(adData.getCustomer().getId());
        mobileCustomer.setFirstName(adData.getCustomer().getFirstName());
        mobileCustomer.setLastName(adData.getCustomer().getLastName());
        mobileCustomer.setCompanyName(adData.getCustomer().getCompanyName());
        mobileCustomer.setEmail(adData.getCustomer().getEmail());

        mobileAd.setMobileCustomer(mobileCustomer);

        return mobileAd;
    }

    private MobileCustomer inboundCustomer(Ad adData) {
        MobileCustomer mobileCustomer = new MobileCustomer();
        mobileCustomer.setId(adData.getCustomer().getId());
        mobileCustomer.setFirstName(adData.getCustomer().getFirstName());
        mobileCustomer.setLastName(adData.getCustomer().getLastName());
        mobileCustomer.setCompanyName(adData.getCustomer().getCompanyName());
        mobileCustomer.setEmail(adData.getCustomer().getEmail());
        return mobileCustomer;

    }

}
