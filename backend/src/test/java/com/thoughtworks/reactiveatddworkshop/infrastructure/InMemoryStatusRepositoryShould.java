package com.thoughtworks.reactiveatddworkshop.infrastructure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InMemoryStatusRepositoryShould {

    @Test
    public void return_always_the_same_status() {
        InMemoryStatusRepository sud = new InMemoryStatusRepository();

        assertThat(sud.getStatus().getStartTimestamp())
                .isEqualTo(sud.getStatus().getStartTimestamp());
    }

}