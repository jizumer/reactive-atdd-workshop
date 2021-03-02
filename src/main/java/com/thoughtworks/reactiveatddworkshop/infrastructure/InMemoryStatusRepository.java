package com.thoughtworks.reactiveatddworkshop.infrastructure;

import com.thoughtworks.reactiveatddworkshop.domain.Status;
import com.thoughtworks.reactiveatddworkshop.domain.StatusRepository;
import org.springframework.stereotype.Component;

@Component
public class InMemoryStatusRepository implements StatusRepository {

    private Status status;

    public InMemoryStatusRepository() {
        this.status = new Status();
    }

    @Override
    public Status getStatus() {
        return status;
    }
}
