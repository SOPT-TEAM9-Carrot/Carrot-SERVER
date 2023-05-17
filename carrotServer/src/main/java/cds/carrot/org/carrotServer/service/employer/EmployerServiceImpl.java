package cds.carrot.org.carrotServer.service.employer;

import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.domain.employer.User;
import cds.carrot.org.carrotServer.infrastructure.review.ReviewEntity;
import cds.carrot.org.carrotServer.infrastructure.review.ReviewRepository;
import cds.carrot.org.carrotServer.infrastructure.user.UserEntity;
import cds.carrot.org.carrotServer.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public User getUserWithReviews(Long userId, int size) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 사용자를 찾을 수 없습니다."));

        List<ReviewEntity> reviewEntities = reviewRepository.findByUserId(userId);

        int maxSize = Math.min(size, reviewEntities.size());

        User user = fromUserEntityToUserMapper(userEntity, maxSize);

        return user;
    }

    private List<Review> getLimitedReviews(List<ReviewEntity> reviewEntityList, int maxSize) {
        return reviewEntityList.stream()
                .limit(maxSize)
                .map(this::fromReviewEntityToReviewMapper)
                .collect(Collectors.toList());
    }

    private User fromUserEntityToUserMapper(UserEntity userEntity, int size) {
        List<ReviewEntity> reviewEntities = userEntity.getReviewEntities();

        List<Review> reviews = getLimitedReviews(reviewEntities, size);

        return User.builder()
                .nickname(userEntity.getNickname())
                .imageUrl(userEntity.getImageUrl())
                .degree(userEntity.getDegree())
                .reviews(reviews)
                .build();
    }

    private Review fromReviewEntityToReviewMapper(ReviewEntity reviewEntity) {
        return Review.builder()
                .reviewerName(reviewEntity.getReviewerName())
                .imageUrl(reviewEntity.getImageUrl())
                .comment(reviewEntity.getComment())
                .userId(reviewEntity.getUser().getUserId())
                .build();
    }
}

