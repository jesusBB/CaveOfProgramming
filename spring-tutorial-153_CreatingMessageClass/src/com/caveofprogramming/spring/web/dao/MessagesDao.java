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
@Component("messagesDao")
public class MessagesDao {

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
	public List<Message> getMessages() {

//		return jdbc.query("select * from offers, users where offers.username = users.username  and users.enabled=true", new OfferRowMapper());
		Criteria crit = session().createCriteria(Message.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}
	
	public List<Message> getMessages(String username) {
		Criteria crit = session().createCriteria(Message.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
//		return jdbc.query("select * from offers, users where offers.username = users.username  and users.enabled=true and offers.username = :username", new MapSqlParameterSource("username",  username) ,new OfferRowMapper());
		
	}
	
	public void update(Message message) {
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
//		
//		return jdbc.update("update offers set text=:text where id=:id", params) == 1;
		session().saveOrUpdate(message);
	}
	
	public void create(Message message) {
			session().save(message);
	}
	
	public void saveOrUpdate(Message message){
		session().saveOrUpdate(message);
	}
	
//	@Transactional
//	public int[] create(List<Offer> offers) {
//		
//		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
//		
//		return jdbc.batchUpdate("insert into offers (username, text ) values (:user.username, :text )", params);
//	}
	
	public boolean delete(int id) {
		Query query = session().createQuery("delete from Message where id =:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
		
//		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
//		return jdbc.update("delete from offers where id=:id", params) == 1;
	}

	public Message getMessage(int id) {
		Criteria crit = session().createCriteria(Message.class);
		crit.add(Restrictions.idEq(id));
		
		return (Message) crit.uniqueResult();
	}
	
}
