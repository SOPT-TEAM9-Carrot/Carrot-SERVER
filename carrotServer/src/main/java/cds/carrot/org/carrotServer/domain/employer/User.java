package cds.carrot.org.carrotServer.domain.employer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class User {

    private Long userId;

    private String nickname;

    private String imageUrl;

    private float degree;
}
