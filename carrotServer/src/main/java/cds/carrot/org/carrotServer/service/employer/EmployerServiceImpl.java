package cds.carrot.org.carrotServer.service.employer;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.controller.employer.dto.response.EmployerResponseDto;
import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.domain.employer.User;
import cds.carrot.org.carrotServer.exception.BadRequestException;
import cds.carrot.org.carrotServer.exception.NotFoundException;
import cds.carrot.org.carrotServer.infrastructure.review.ReviewEntity;
import cds.carrot.org.carrotServer.infrastructure.review.ReviewRepository;
import cds.carrot.org.carrotServer.infrastructure.user.UserEntity;
import cds.carrot.org.carrotServer.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {
    private static final Logger logger = LoggerFactory.getLogger(EmployerServiceImpl.class);

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public EmployerResponseDto getUserWithReviews(String auth, Long userId, int size) {
        if (!("0".equals(auth) || "1".equals(auth))) {
            throw new BadRequestException(ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION, ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION.getMessage());
        }

        if (size < 0) {
            throw new BadRequestException(ErrorType.REQUEST_SIZE_EXCEPTION, ErrorType.REQUEST_SIZE_EXCEPTION.getMessage());
        }

        List<ReviewEntity> reviewEntities = reviewRepository.findByUserId(userId);

        logger.info("reviewEntities: {}", reviewEntities);

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorType.NOT_FOUND_USER_EXCEPTION, ErrorType.NOT_FOUND_USER_EXCEPTION.getMessage()));

        int maxSize = Math.min(size, reviewEntities.size());

        List<Review> reviews = getLimitedReviews(reviewEntities, maxSize);

        logger.info("reviews: {}", reviews);

        User user = fromUserEntityToUserMapper(userEntity);

        return EmployerResponseDto.of(
                user.getUserId(),
                user.getNickname(),
                user.getImageUrl(),
                user.getDegree(),
                reviews
        );
    }

    private List<Review> getLimitedReviews(List<ReviewEntity> reviewEntityList, int maxSize) {
        return reviewEntityList.stream()
                .limit(maxSize)
                .map(this::fromReviewEntityToReviewMapper)
                .collect(Collectors.toList());
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

