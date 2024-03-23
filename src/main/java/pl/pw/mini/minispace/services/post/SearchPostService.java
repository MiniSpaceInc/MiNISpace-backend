package pl.pw.mini.minispace.services.post;

import pl.pw.mini.minispace.entities.Post;

public interface SearchPostService {
    Post findById(Long id);
}
