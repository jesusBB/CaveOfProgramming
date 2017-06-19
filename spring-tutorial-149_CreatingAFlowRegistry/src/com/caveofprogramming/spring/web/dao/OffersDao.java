package com.caveofprogramming.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("offersDao")
public class OffersDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	public List<Offer> getOffers() {

//		return jdbc.query("select * from offers, users where offers.username = users.username  and users.enabled=true", new OfferRowMapper());
		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}
	
	public List<Offer> getOffers(String username) {
		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
//		return jdbc.query("select * from offers, users where offers.username = users.username  and users.enabled=true and offers.username = :username", new MapSqlParameterSource("username",  username) ,new OfferRowMapper());
		
	}
	
	public void update(Offer offer) {
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
//		
//		return jdbc.update("update offers set text=:text where id=:id", params) == 1;
		session().saveOrUpdate(offer);
	}
	
	public void create(Offer offer) {
			session().save(offer);
	}
	
//	@Transactional
//	public int[] create(List<Offer> offers) {
//		
//		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
//		
//		return jdbc.batchUpdate("insert into offers (username, text ) values (:user.username, :text )", params);
//	}
	
	public boolean delete(int id) {
		Query query = session().createQuery("delete from Offer where id =:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
		
//		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
//		return jdbc.update("delete from offers where id=:id", params) == 1;
	}

	public Offer getOffer(int id) {
		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(id));
		
		return (Offer) crit.uniqueResult();
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("id", id);
//
//		return jdbc.queryForObject("select * from offers, users where offers.username = users.username  and users.enabled=true  and id=:id", params,
//				new OfferRowMapper());
	}
	
}
