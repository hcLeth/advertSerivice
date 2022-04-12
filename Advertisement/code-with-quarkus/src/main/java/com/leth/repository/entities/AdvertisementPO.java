package com.leth.repository.entities;

import com.leth.domain.*;
import com.leth.domain.Id;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Advertisements")
@NamedQueries({
        @NamedQuery(name = "AdvertisementPO.findByPhoneNumber", query = "Select a FROM AdvertisementPO a where a.phoneNumber=:phoneNumber")
})

public class AdvertisementPO {
    public static final String FIND_BY_PHONENUMBER = "AdvertisementPO.findByPhoneNumber";
    public static final String PHONENUMBER_PARAM = "phoneNumber";

    @javax.persistence.Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    private UUID id;

    @Column(name = "CATEGORY", columnDefinition = "varchar(40)")
    private String category;
    @Column(name = "TYPE", columnDefinition = "varchar(40)")
    private String type;
    @Column(name = "HEADERTEXT", columnDefinition = "varchar(100)")
    private String headerText;
    @Column(name = "BODYTEXT", columnDefinition = "varchar(280)")
    private String bodyText;
    @Column(name = "PRICE", columnDefinition = "int")
    private int price;
    @Column(name = "PHONENUMBER", columnDefinition = "varchar(40)")
    private String phoneNumber;
    @Column(name = "IMAGEURL", columnDefinition = "varchar(2048)")
    private String imageUrl;


    public AdvertisementPO(){

    }

    public AdvertisementPO(Category category, com.leth.domain.Type type,
                           HeaderText headerText, BodyText bodyText,
                           Price price, PhoneNumber phoneNumber,
                           ImageUrl imageUrl){
    this.category = category.name();
    this.type = type.name();
    this.headerText = headerText.getValue();
    this.bodyText = bodyText.getValue();
    this.price = price.getValue();
    this.phoneNumber = phoneNumber.getValue();
    this.imageUrl = imageUrl.getValue();
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Advertisement toAdvertisement(){
        return new Advertisement(new Id(id), Category.valueOf(category), com.leth.domain.Type.valueOf(type),
                new HeaderText(headerText), new BodyText(bodyText), new Price(price), new PhoneNumber(phoneNumber),
                new ImageUrl(imageUrl));
    }
}
