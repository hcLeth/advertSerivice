package com.leth.service.response;

import com.leth.domain.HeaderText;
import com.leth.domain.PhoneNumber;

public class CreateAdvertisementResponse {
    private final PhoneNumber phoneNumber;
    public CreateAdvertisementResponse(PhoneNumber phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }
}
