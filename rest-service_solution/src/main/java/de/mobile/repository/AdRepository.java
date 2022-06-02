package de.mobile.repository;

import de.mobile.entity.MobileAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<MobileAd, Long> {

    /* public Long create(MobileAd ad) {
        throw new RuntimeException("not implemented yet");
    }*/

    //@Query("select a from MOBILE_AD a join fetch a.MOBILE_CUSTOMER where a.ID = ?1")
    //public MobileAd get(Long adId);

    /*public List<MobileAd> list() {
        return new ArrayList<>();
    }*/

}
