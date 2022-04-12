package com.leth.integration.advertisementService;

import com.leth.domain.Advertisement;
import com.leth.domain.PhoneNumber;
import com.leth.repository.Repository;
import com.leth.repository.entities.AdvertisementPO;
import com.leth.service.request.CreateAdRequest;
import com.leth.service.request.GetAdvertisementRequest;
import com.leth.service.response.CreateAdvertisementResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
@Transactional
public class AdvertisementService {
    private final Repository repository;
    @Inject
    public AdvertisementService(Repository repository){this.repository = repository;}

    public Advertisement get(GetAdvertisementRequest request){ return repository.getAdvertisement(request.getId());}
    public List<Advertisement> getAll(){return repository.getAllAds();}

    public CreateAdvertisementResponse createAd(CreateAdRequest request){
        PhoneNumber advertisement = repository.createAdvertisement(request.getCategory(), request.getType(),
                request.getHeaderText(), request.getBodyText(), request.getPrice(), request.getPhoneNumber(),
                request.getImageUrl());
        return new CreateAdvertisementResponse(advertisement);
    }
}
