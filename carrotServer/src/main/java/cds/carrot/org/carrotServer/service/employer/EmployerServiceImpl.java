package cds.carrot.org.carrotServer.service.employer;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.domain.employer.User;
import cds.carrot.org.carrotServer.exception.NotFoundException;
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
    public List<Review> getByUserId(Long userId) {
        List<ReviewEntity> reviewEntities = reviewRepository.findByUserId(userId);
        return reviewEntities
                .stream()
                .map(this::fromReviewEntityToReviewMapper)
                .collect(Collectors.toList());
    }

    @Override
    public User getById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorType.NOT_FOUND_USER_EXCEPTION, ErrorType.NOT_FOUND_USER_EXCEPTION.getMessage()));
        return fromUserEntityToUserMapper(userEntity);
    }


    private User fromUserEntityToUserMapper(UserEntity userEntity) {
        return User.builder()
                .userId(userEntity.getId())
                .nickname(userEntity.getNickname())
                .imageUrl(userEntity.getImageUrl())
                .degree(userEntity.getDegree())
                .build();
    }

    private Review fromReviewEntityToReviewMapper(ReviewEntity reviewEntity) {
        return Review.builder()
                .reviewerName(reviewEntity.getReviewerName())
                .imageUrl(reviewEntity.getImageUrl())
                .comment(reviewEntity.getComment())
                .build();
    }
}

