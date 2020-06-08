package com.albi.helidon.mp.jpa.service;

import com.albi.helidon.mp.jpa.repository.GreetingRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class GreetingService {

    @Inject
    GreetingRepository greetingRepository;

    public String findBySalutation(String salutation) {
        return greetingRepository.findBySalutation(salutation).toString();
    }

}
