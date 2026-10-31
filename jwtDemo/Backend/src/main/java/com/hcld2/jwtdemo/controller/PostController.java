package com.hcld2.jwtdemo.controller;

import com.hcld2.jwtdemo.dto.PostRequest;
import com.hcld2.jwtdemo.service.PostService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<?> getAllPost(){
        return postService.getAllPosts();
    }

    @PostMapping
    @SecurityRequirement(name = "jwt-demo-api")
    public ResponseEntity<?> create(@Valid @RequestBody PostRequest req, Authentication auth){
        return postService.create(req, auth);
    }
}
