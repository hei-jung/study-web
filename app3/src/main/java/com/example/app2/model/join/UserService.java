package com.example.app2.model.join;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repos;
	
	public void addUser(Usertb u){
		repos.save(u);
	}
	
	public Usertb getUser(String id){
		return repos.getOne(id);
	}
	
	public List<Usertb> getUsers(){
		return repos.findAll();
	}
	
	public void editUser(Usertb u){
		repos.save(u);
	}
	
	public void delUser(String id){
		repos.deleteById(id);
	}
}
