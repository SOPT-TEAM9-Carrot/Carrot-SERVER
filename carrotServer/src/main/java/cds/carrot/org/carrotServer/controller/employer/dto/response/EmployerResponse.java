package cds.carrot.org.carrotServer.controller.employer.dto.response;

import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.domain.employer.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class EmployerResponse {

    private Long userId;
    private String nickname;
    private String imageUrl;
    private float degree;
    private List<Review> reviews;


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
