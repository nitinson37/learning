package de.mobile.repository;


import de.mobile.AppConfig;
import de.mobile.Category;
import de.mobile.entity.MobileAd;
import de.mobile.entity.MobileCustomer;
import de.mobile.model.Ad;
import de.mobile.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AppConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class AdRepositoryTests {

    @Autowired
    private AdRepository repository;

    @Test
    public void testFindAll() {

        Customer mockCustomer = new Customer(1L,"Nitin","Soni","Amdocs","nitinsoni.nitj@gmail.com");
        Ad mockAd = new Ad(1L,"BMW","520","Black 100000 kms", Category.Car,mockCustomer, new BigDecimal(20000));

        repository.save(inbound(mockAd));

        List<MobileAd> adsList = repository.findAll();
        assertEquals(1,adsList.size());
    }

    @Test
    public void testFindOne() {
        MobileAd mobileAd = repository.findById(1L).get();
        assertEquals("BMW",mobileAd.getMake());
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
