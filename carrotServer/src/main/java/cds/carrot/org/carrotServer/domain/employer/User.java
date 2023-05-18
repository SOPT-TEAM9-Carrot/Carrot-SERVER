package cds.carrot.org.carrotServer.domain.employer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private Long userId;

    private String nickname;

    private String imageUrl;

    private float degree;
}
