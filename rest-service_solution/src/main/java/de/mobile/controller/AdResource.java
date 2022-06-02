package de.mobile.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import de.mobile.model.Ad;
import de.mobile.service.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("ad")
public class AdResource {

    Logger logger = LoggerFactory.getLogger(AdResource.class);

    private final AdService adService;

    @Inject
    public AdResource(AdService adService) {
        this.adService = adService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Ad get(@PathVariable("id") Long adId) {
        logger.trace("Inside AdResource get(id)");
        return adService.get(adId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Ad> list() {
        logger.trace("Inside AdResource list()");
        return adService.list();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Long addAd(@Valid @RequestBody Ad ad) {
        logger.trace("Inside AdResource addAd(Ad)");
        return adService.create(ad);
    }

}
