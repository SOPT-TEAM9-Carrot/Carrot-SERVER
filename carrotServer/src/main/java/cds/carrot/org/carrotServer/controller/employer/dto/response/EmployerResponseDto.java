package cds.carrot.org.carrotServer.controller.employer.dto.response;

import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.service.employer.EmployerServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
@NoArgsConstructor
public class EmployerResponseDto {

    private Long userId;

    private String nickname;

    private String imageUrl;

    private float degree;

    private List<Review> reviews;

    private EmployerResponseDto(Long userId, String nickname, String imageUrl, float degree, List<Review> reviews) {
        this.userId = userId;
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.degree = degree;
        this.reviews = reviews;
    }

    public static EmployerResponseDto of(Long userId, String nickname, String imageUrl, float degree, List<Review> reviews) {
        return new EmployerResponseDto(userId, nickname, imageUrl, degree, reviews);
    }

    @Override
    public String toString() {
        return "EmployerResponseDto{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", degree=" + degree +
                ", reviews=" + reviews +
                '}';
    }
}
