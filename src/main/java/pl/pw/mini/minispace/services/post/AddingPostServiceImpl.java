package pl.pw.mini.minispace.services.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.dtos.PostDto;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddingPostServiceImpl implements AddingPostService {

    @Override
    public void addPost(PostDto postDto, Long eventId) {
        throw new UnsupportedOperationException();
    }
}
