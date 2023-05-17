package cds.carrot.org.carrotServer.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class User {

    private String nickname;

    private String imageUrl;

    private float degree;
}
