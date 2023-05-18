package cds.carrot.org.carrotServer.controller.post.dto.response;

import cds.carrot.org.carrotServer.domain.post.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class PostListResponse {

    List<PostResponse> posts = new ArrayList<>();

    public static PostListResponse of(List<Post> posts) {
        return PostListResponse.builder()
                .posts(posts.stream()
                        .map(PostResponse::of)
                        .collect(Collectors.toList()))
                .build();
    }

    @Getter
    @Builder
    static class PostResponse {
        String title;
        String image;
        int hourlyWage;

        public static PostResponse of(Post post) {
            return PostResponse.builder()
                    .title(post.getTitle())
                    .image(post.getImageUrl())
                    .hourlyWage(post.getHourlyWage())
                    .build();
        }
    }
}
