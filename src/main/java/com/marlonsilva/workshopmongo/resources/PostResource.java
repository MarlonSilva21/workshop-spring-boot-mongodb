package com.marlonsilva.workshopmongo.resources;

import com.marlonsilva.workshopmongo.domain.Post;
import com.marlonsilva.workshopmongo.resources.util.URL;
import com.marlonsilva.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable String id) {

        Post post = postService.findPostById(id);

        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findPostByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

        text = URL.decodeParam(text);
        List<Post> postList = postService.findByTitle(text);

        return ResponseEntity.ok().body(postList);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> postList = postService.fullSearch(text, min, max);

        return ResponseEntity.ok().body(postList);
    }
}
