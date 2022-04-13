package com.leth.repository;

import com.leth.domain.*;
import com.leth.repository.entities.AdvertisementPO;
import org.jboss.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class Repository {
    private final EntityManager entityManager;

    @Inject
    public Repository(EntityManager entityManager){this.entityManager =entityManager;}
    @Inject
    Logger log;

    public PhoneNumber createAdvertisement(Category category, Type type,
                                           HeaderText headerText, BodyText bodyText,
                                           Price price, PhoneNumber phoneNumber,
                                           ImageUrl imageUrl){
        AdvertisementPO advertisementPO = new AdvertisementPO(category, type, headerText, bodyText, price, phoneNumber, imageUrl);
        entityManager.persist(advertisementPO);
        log.info(advertisementPO);
        return new PhoneNumber(advertisementPO.getPhoneNumber());
    }

    public List<Advertisement> getAllAds(){
        try{
            List<AdvertisementPO> advertisementPOList = entityManager.createQuery(
                    "SELECT a FROM AdvertisementPO a", AdvertisementPO.class).getResultList();
            List<Advertisement> adList = advertisementPOList.stream().map(AdvertisementPO::toAdvertisement).toList();
            log.info(adList);
            return adList;
        }catch (NoResultException e){
            return null;
        }
    }

public List<Advertisement> findAdvertisement(PhoneNumber phoneNumber){
        try{
            List<AdvertisementPO> advertisementPOList =entityManager
                    .createNamedQuery(AdvertisementPO.FIND_BY_PHONENUMBER, AdvertisementPO.class)
                    .getResultList();
            return advertisementPOList.stream().map(AdvertisementPO::toAdvertisement).toList();
        } catch (NoResultException e){
            return null;
        }
}
public Advertisement getAdvertisement(Id id){return entityManager.find(AdvertisementPO.class, id.getUuid()).toAdvertisement();}
}
