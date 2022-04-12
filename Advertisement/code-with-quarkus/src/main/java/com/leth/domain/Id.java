package com.leth.domain;

import java.util.UUID;

public class Id {
    private final UUID value;
    public Id(UUID id){this.value = id;}


    public Id(String uuid) {
        this.value = UUID.fromString(uuid);
    }

    public String getRaw() {
        return value.toString();
    }
    public UUID getUuid() {
        return value;
    }
}
