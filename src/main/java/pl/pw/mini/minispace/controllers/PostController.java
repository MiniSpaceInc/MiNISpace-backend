package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.mini.minispace.dtos.PostDto;
import pl.pw.mini.minispace.services.post.PostServiceFacade;

@RequestMapping("/api/posts")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostServiceFacade postServiceFacade;

    @PostMapping("/add")
    public ResponseEntity<PostDto> addNewPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postServiceFacade.addPost(postDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> findPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postServiceFacade.findById(postId));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Object> deletePost(@PathVariable Long postId) {
        postServiceFacade.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
