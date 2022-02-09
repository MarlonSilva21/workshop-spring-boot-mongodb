package com.marlonsilva.workshopmongo.service;

import com.marlonsilva.workshopmongo.domain.Post;
import com.marlonsilva.workshopmongo.repository.PostRepository;
import com.marlonsilva.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findPostById(String id){

        Optional<Post> post =  postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));

    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
