package cds.carrot.org.carrotServer.infrastructure.review;

import cds.carrot.org.carrotServer.infrastructure.user.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewEntity {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "reviewer_nickname", nullable = false)
    private String reviewerNickname;

    @Column(nullable = false)
    private String comment;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}
