package com.hcld2.jwtdemo.service;

import com.hcld2.jwtdemo.dto.PostRequest;
import com.hcld2.jwtdemo.dto.PostResponse;
import com.hcld2.jwtdemo.entity.Post;
import com.hcld2.jwtdemo.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public ResponseEntity<?> create(PostRequest post, Authentication auth){
        if (auth == null || auth.getName() == null) {
            return ResponseEntity.status(401).body("Unauthorized: authentication required");
        }
        postRepository.save(new Post(post.title(), post.content(), auth.getName()));
        return ResponseEntity.ok(
                new PostResponse(post.title(), post.content(), auth.getName())
        );
    }
}
