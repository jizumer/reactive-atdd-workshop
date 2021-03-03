package com.thoughtworks.reactiveatddworkshop.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StatusShould {

    @Test
    public void return_an_incremental_number_of_requests_and_timestamp() {
        Status sut = new Status();
        int firstNumberOfRequests = sut.getNumberOfStatusRequests();
        int secondNumberOfRequests = sut.getNumberOfStatusRequests();
        
        assertThat(firstNumberOfRequests).isLessThan(secondNumberOfRequests);
    }

}