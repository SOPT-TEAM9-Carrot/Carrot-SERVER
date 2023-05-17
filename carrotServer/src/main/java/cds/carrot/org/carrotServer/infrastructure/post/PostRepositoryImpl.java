package cds.carrot.org.carrotServer.infrastructure.post;

import org.springframework.data.repository.Repository;

public interface PostRepositoryImpl extends Repository<PostEntity, Long>, PostRepository {
}
