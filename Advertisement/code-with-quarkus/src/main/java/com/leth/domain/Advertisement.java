package com.leth.domain;


import com.leth.resource.dto.AdvertisementDTO;

public class Advertisement {
    private final Id id;
    private final Category category;
    private final Type type;
    private final HeaderText headerText;
    private final BodyText bodyText;
    private final Price price;
    private final PhoneNumber phoneNumber;
    private final ImageUrl imageUrl;

    public Advertisement(Id id, Category category, Type type,
                         HeaderText headerText, BodyText bodyText,
                         Price price, PhoneNumber phoneNumber,
                         ImageUrl imageUrl){
        this.id = id;
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.bodyText = bodyText;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
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

    public AdvertisementDTO toDTO(){
        return new AdvertisementDTO(this.id, this.category, this.type, this.headerText, this.bodyText,
                this.price, this.phoneNumber, this.imageUrl);
    }
}
