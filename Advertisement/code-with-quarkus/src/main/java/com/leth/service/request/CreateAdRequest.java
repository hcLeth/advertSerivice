package com.leth.service.request;

import com.leth.domain.*;

public class CreateAdRequest {
    private final Id id;
    private final Category category;
    private final Type type;
    private final HeaderText headerText;
    private final BodyText bodyText;
    private final Price price;
    private final PhoneNumber phoneNumber;
    private final ImageUrl imageUrl;

    public CreateAdRequest(String id, String category, String type, String headerText, String bodyText,
                           int price, String phoneNumber, String imageUrl) {
        this.id = new Id(id);
        this.category = Category.valueOf(category);
        this.type = Type.valueOf(type);
        this.headerText = new HeaderText(headerText);
        this.bodyText = new BodyText(bodyText);
        this.price = new Price(price);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.imageUrl = new ImageUrl(imageUrl);
    }

    public Id getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public HeaderText getHeaderText() {
        return headerText;
    }

    public BodyText getBodyText() {
        return bodyText;
    }

    public Price getPrice() {
        return price;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public ImageUrl getImageUrl() {
        return imageUrl;
    }
}
