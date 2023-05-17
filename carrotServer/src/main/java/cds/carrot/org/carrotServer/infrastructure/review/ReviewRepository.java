package cds.carrot.org.carrotServer.infrastructure.review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    List<ReviewEntity> findAll();

    Optional<ReviewEntity> findById(Long Id);
}
