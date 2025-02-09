package com.monprojet.dao;

import com.monprojet.models.OffreNavette;
import java.util.List;

public interface OffreNavetteDAO {
    List<OffreNavette> getAllOffers();
    OffreNavette getOfferById(int id);
    boolean addOffer(OffreNavette offer);
    boolean updateOffer(OffreNavette offer);
    boolean deleteOffer(int id);
}
