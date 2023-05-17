package cds.carrot.org.carrotServer.infrastructure.post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    List<PostEntity> findAll();
    Optional<PostEntity> findById(Long id);
}
