package cds.carrot.org.carrotServer.controller.post.dto.response;

import cds.carrot.org.carrotServer.domain.employer.User;
import cds.carrot.org.carrotServer.domain.post.Post;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class RecommendPostListResponse {

    private String nickname;
    private List<RecommendPostResponse> posts = new ArrayList<>();

    public static RecommendPostListResponse of (String nickname, List<Post> posts) {
        return RecommendPostListResponse
                .builder()
                .nickname(nickname)
                .posts(posts.stream()
                        .map(RecommendPostResponse::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
