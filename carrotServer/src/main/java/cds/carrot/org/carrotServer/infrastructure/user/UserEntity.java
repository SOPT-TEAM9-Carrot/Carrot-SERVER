package cds.carrot.org.carrotServer.infrastructure.user;

import cds.carrot.org.carrotServer.infrastructure.review.ReviewEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ReviewEntity> reviewEntities = new ArrayList<>();

    @Column(nullable = false)
    private String nickname;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private float degree;
}
