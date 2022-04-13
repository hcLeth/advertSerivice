package com.leth.resource;

import com.leth.domain.Advertisement;
import com.leth.domain.PhoneNumber;
import com.leth.integration.advertisementService.AdvertisementService;
import com.leth.resource.dto.AdvertisementDTO;
import com.leth.resource.dto.CreateAdDTO;
import com.leth.service.request.CreateAdRequest;
import org.jboss.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/advertisement")
public class AdvertisementResource {
    private final AdvertisementService advertisementService;

    @Inject
    public  AdvertisementResource(AdvertisementService advertisementService){
        this.advertisementService = advertisementService;
    }
    @Inject
    Logger log;

    @Path("/createad")
    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public PhoneNumber createAd(CreateAdDTO advertisement){
        return new PhoneNumber(advertisementService.createAd(advertisement.toRequest()).getPhoneNumber().getValue());
    }

    @Path("/advertisements")
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<Advertisement> showAds(){
        List<Advertisement> advertisementList = advertisementService.getAll();

        return advertisementList;
    }
}
