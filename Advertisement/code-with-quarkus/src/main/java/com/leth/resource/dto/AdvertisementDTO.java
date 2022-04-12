package com.leth.resource.dto;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.leth.domain.*;
import com.leth.service.request.CreateAdRequest;
import io.vertx.core.json.Json;

public class AdvertisementDTO {
    private final String id;
    private final String category;
    private final String type;
    private final String headerText;
    private final String bodyText;
    private final int price;
    private final String phoneNumber;
    private final String imageUrl;

    public AdvertisementDTO(Advertisement advertisement){
        this.id = advertisement.getId().getRaw();
        this.category = advertisement.getCategory().name();
        this.type = advertisement.getType().name();
        this.headerText = advertisement.getHeaderText().getValue();
        this.bodyText = advertisement.getBodyText().getValue();
        this.price = advertisement.getPrice().getValue();
        this.phoneNumber = advertisement.getPhoneNumber().getValue();
        this.imageUrl = advertisement.getImageUrl().getValue();
    }

    public CreateAdRequest toRequest(){return new CreateAdRequest(id, category, type, headerText, bodyText, price,
            phoneNumber, imageUrl);}
}
