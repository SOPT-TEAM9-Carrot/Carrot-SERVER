package cds.carrot.org.carrotServer.infrastructure.review;

import java.util.List;

public interface ReviewRepository {

    List<ReviewEntity> findByUserId(Long userId);
}
