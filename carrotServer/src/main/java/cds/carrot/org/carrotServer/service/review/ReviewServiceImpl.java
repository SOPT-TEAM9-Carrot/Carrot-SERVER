package cds.carrot.org.carrotServer.service.review;

import cds.carrot.org.carrotServer.domain.review.Review;
import cds.carrot.org.carrotServer.infrastructure.review.ReviewEntity;
import cds.carrot.org.carrotServer.infrastructure.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAll() {
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();
        return reviewEntities
                .stream()
                .map(this::fromReviewEntityToReviewMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Review getById(Long reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("id에 해당하는 리뷰가 없습니다."));
        return fromReviewEntityToReviewMapper(reviewEntity);
    }

    private Review fromReviewEntityToReviewMapper(ReviewEntity reviewEntity) {
        return Review.builder()
                .reviewerName(reviewEntity.getReviewerName())
                .imageUrl(reviewEntity.getImageUrl())
                .comment(reviewEntity.getComment())
                .build();
    }
}
