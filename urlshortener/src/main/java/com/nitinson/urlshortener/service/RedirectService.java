package com.nitinson.urlshortener.service;

import com.nitinson.urlshortener.entity.Redirect;
import com.nitinson.urlshortener.exception.BadRequestException;
import com.nitinson.urlshortener.exception.ResourceNotFoundException;
import com.nitinson.urlshortener.repository.RedirectRepository;
import com.nitinson.urlshortener.request.RedirectCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    private RedirectRepository redirectRepository;

    @Autowired
    public RedirectService(RedirectRepository redirectRepository) {
        this.redirectRepository = redirectRepository;
    }

    public Optional<Redirect> createRedirect(RedirectCreationRequest redirectCreationRequest){

        if(redirectRepository.existsByAlias(redirectCreationRequest.getAlias())){
           throw new BadRequestException("Alias already exists");
        }
        Redirect redirect = redirectRepository.save(
                new Redirect(redirectCreationRequest.getAlias(), redirectCreationRequest.getUrl()));

        return Optional.ofNullable(redirect);
    }

    public Redirect getRedirect(String alias){

        Redirect redirect = redirectRepository.findByAlias(alias)
                .orElseThrow(() -> new ResourceNotFoundException("Alias not there. Try making a new one ?"));
        return redirect;
    }
}
