package pl.pw.mini.minispace.services.post;

import org.springframework.data.jpa.domain.Specification;
import pl.pw.mini.minispace.entities.Post;

import java.time.LocalDateTime;

public class PostSpecifications {
    public static Specification<Post> hasEqualEventId(Long eventId) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.join("event").get("id"), eventId));
    }

    public static Specification<Post> hasDatePostedFrom(LocalDateTime dateFrom) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("datePosted"), dateFrom));
    }

    public static Specification<Post> hasDatePostedTo(LocalDateTime dateFrom) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("datePosted"), dateFrom));
    }
}
