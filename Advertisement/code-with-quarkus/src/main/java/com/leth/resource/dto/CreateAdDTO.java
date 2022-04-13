package com.leth.resource.dto;

import com.leth.service.request.CreateAdRequest;

public class CreateAdDTO {
    private final String category;
    private final String type;
    private final String headerText;
    private final String bodyText;
    private final int price;
    private final String phoneNumber;
    private final String imageUrl;

    public CreateAdDTO(String category, String type, String headerText, String bodyText, int price, String phoneNumber, String imageUrl) {
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.bodyText = bodyText;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public int getPrice() {
        return price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CreateAdRequest toRequest(){return new CreateAdRequest(category, type, headerText, bodyText, price,
            phoneNumber, imageUrl);}
}
