package cds.carrot.org.carrotServer.controller.post.dto.response;

import cds.carrot.org.carrotServer.domain.post.Category;
import cds.carrot.org.carrotServer.domain.post.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class PostResponse {

    Long userId;
    String image;
    List<String> categories = new ArrayList<>();
    String title;
    int hourlyWage;
    String content;
    String address;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .userId(post.getUserId())
                .image(post.getImageUrl())
                .categories(post
                        .getCategories()
                        .stream()
                        .map(Category::getName)
                        .collect(Collectors.toList()))
                .title(post.getTitle())
                .hourlyWage(post.getHourlyWage())
                .content(post.getContent())
                .address(post.getAddress())
                .build();
    }

}
