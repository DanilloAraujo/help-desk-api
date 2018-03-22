package com.example.helpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.helpdesk.entity.User;
import com.example.helpdesk.repository.UserRepository;
import com.example.helpdesk.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmai(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		this.userRepository.delete(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.userRepository.findAll(pages);
	}

}