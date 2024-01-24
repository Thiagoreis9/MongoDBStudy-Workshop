package com.thiagoreis.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagoreis.workshopmongo.domain.Post;
import com.thiagoreis.workshopmongo.repository.PostRepository;
import com.thiagoreis.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Post insert(Post obj) {
		return repository.insert(obj);
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

	public Post update(Post obj) {
		Post newObj = findById(obj.getId());

		updateData(newObj, obj);
		return repository.save(newObj);
	}

	public void updateData(Post newObj, Post obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setBody(obj.getBody());
	}

}