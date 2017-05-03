package com.caveofprogramming.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.dao.OffersDao;

@Service("offersService")
public class OffersService {
	
	private OffersDao offersDao;
	
	@Autowired	
	public void setOffersDAO(OffersDao offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent(){
		return offersDao.getOffers();
		
	}
	
	public void create(Offer offer){
		offersDao.create(offer);
	}

	public void throwsTestException() {
		offersDao.getOffer(98798779);
		
	}
}
