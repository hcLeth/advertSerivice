package com.leth.service.request;

import com.leth.domain.Id;

public class GetAdvertisementRequest {
    private final Id id;

    public GetAdvertisementRequest(String id) { this.id = new Id(id);}

    public Id getId() {return id;}
}
