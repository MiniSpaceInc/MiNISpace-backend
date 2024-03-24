package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.mini.minispace.dtos.post.PostDto;
import pl.pw.mini.minispace.dtos.post.PostSearchDetailsDto;
import pl.pw.mini.minispace.dtos.post.RegisterPostDto;
import pl.pw.mini.minispace.services.post.PostServiceFacade;

@RequestMapping("/api/posts")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostServiceFacade postServiceFacade;

    @PostMapping("/add")
    public ResponseEntity<PostDto> addNewPost(@RequestBody RegisterPostDto postDto) {
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

    @PostMapping("/search")
    public ResponseEntity<Page<PostDto>> searchPosts(@RequestBody PostSearchDetailsDto searchDetailsDto) {
        return ResponseEntity.ok(postServiceFacade.searchPosts(searchDetailsDto));
    }
}
