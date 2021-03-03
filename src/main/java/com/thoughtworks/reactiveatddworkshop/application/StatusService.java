package com.thoughtworks.reactiveatddworkshop.application;

import com.thoughtworks.reactiveatddworkshop.domain.Status;
import com.thoughtworks.reactiveatddworkshop.domain.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status getStatus() {
        return statusRepository.getStatus();
    }
}
