package com.leth.resource.dto;

import com.leth.domain.*;
import com.leth.service.request.CreateAdRequest;

public class AdvertisementDTO {
    private final String id;
    private final String category;
    private final String type;
    private final String headerText;
    private final String bodyText;
    private final int price;
    private final String phoneNumber;
    private final String imageUrl;


    public AdvertisementDTO(Id id, Category category, Type type, HeaderText headerText, BodyText bodyText,
                            Price price, PhoneNumber phoneNumber, ImageUrl imageUrl){
        this.id = id.getRaw();
        this.category = category.toString();
        this.type = type.toString();
        this.headerText = headerText.getValue();
        this.bodyText = bodyText.getValue();
        this.price = price.getValue();
        this.phoneNumber = phoneNumber.getValue();
        this.imageUrl = imageUrl.getValue();
    }
}
