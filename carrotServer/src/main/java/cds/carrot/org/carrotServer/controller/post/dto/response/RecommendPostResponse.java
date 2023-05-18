package cds.carrot.org.carrotServer.controller.post.dto.response;

import cds.carrot.org.carrotServer.domain.post.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecommendPostResponse {

    String title;
    String image;
    int monthlyWage;

    public static RecommendPostResponse of (Post post) {
        return RecommendPostResponse.builder()
                .title(post.getTitle())
                .image(post.getImageUrl())
                .monthlyWage(post.getMonthlyWage())
                .build();
    }
}