package cds.carrot.org.carrotServer.controller.post.dto.response;

import cds.carrot.org.carrotServer.domain.employer.User;
import cds.carrot.org.carrotServer.domain.post.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RecommendPostListResponse {

    private String nickname;






//    private List<RecommendPostResponse> posts = new ArrayList<>();

    public static RecommendPostListResponse of (String nickname, List<Post> posts) {
        List<RecommendPostResponse> recommendPosts = posts.stream()
                .map(RecommendPostResponse::of)
                .collect(Collectors.toList());
        return RecommendPostListResponse
                .builder()
                .nickname(nickname)
//                .posts(recommendPosts)
                .build();
    }
}
