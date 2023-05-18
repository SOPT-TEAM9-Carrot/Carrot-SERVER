package cds.carrot.org.carrotServer.domain.employer;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class User {

    private String nickname;

    private String imageUrl;

    private float degree;

    private List<Review> reviews;
}
