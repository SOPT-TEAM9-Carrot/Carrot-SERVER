package cds.carrot.org.carrotServer.service.review;

import cds.carrot.org.carrotServer.domain.review.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();

    Review getById(Long reviewId);
}
