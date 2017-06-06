package com.caveofprogramming.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("usersDao")
public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public boolean create(User user) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("name", user.getName());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		
		return jdbc.update("insert into users (username, name, password, email, enabled, authority) values (:username, :name, :password, :email, :enabled, :authority)", params) == 1;
		
//		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
	}
	
	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
//		return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
		return session().createQuery("from User ").list();
	}
	
	
	
}
