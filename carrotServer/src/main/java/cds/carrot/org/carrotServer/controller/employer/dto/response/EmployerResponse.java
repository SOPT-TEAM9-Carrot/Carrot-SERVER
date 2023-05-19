package cds.carrot.org.carrotServer.controller.employer.dto.response;

import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.domain.employer.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
public class EmployerResponse {

    private Long userId;

    private String nickname;

    private String imageUrl;

    private float degree;

    private List<Review> reviews;

    private EmployerResponse(Long userId, String nickname, String imageUrl, float degree, List<Review> reviews) {
        this.userId = userId;
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.degree = degree;
        this.reviews = reviews;
    }

    public static EmployerResponse of(User user, List<Review> reviews) {
        return EmployerResponse.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .imageUrl(user.getImageUrl())
                .degree(user.getDegree())
                .reviews(reviews)
                .build();
    }
}
