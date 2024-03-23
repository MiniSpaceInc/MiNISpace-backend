package pl.pw.mini.minispace.services.post;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;

@AllArgsConstructor
@Service
public class DeletePostServiceImpl implements DeletePostService {

    private PostRepository postRepository;

    @Override
    public void deletePost(Long id) {
        if (postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException(String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Post", id));
        }
    }
}
