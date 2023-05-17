package cds.carrot.org.carrotServer.infrastructure.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(name = "image_url", nullable = false)
    private String image;

    @Column(nullable = false)
    private float degree;

    private UserEntity(String nickname, String image, float degree) {
        this.nickname = nickname;
        this.image = image;
        this.degree = degree;
    }

    public static UserEntity newInstance(String nickname, String image, float degree) {
        return new UserEntity(nickname, image, degree);
    }
}
