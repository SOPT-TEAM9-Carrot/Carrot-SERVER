package cds.carrot.org.carrotServer.infrastructure.post;

import cds.carrot.org.carrotServer.infrastructure.category.CategoryEntity;
import cds.carrot.org.carrotServer.infrastructure.user.UserEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column
    private String address;

    @Column(name = "hourly_wage", nullable = false)
    private int hourlyWage;

    @Column(name = "monthly_wage", nullable = false)
    private int monthlyWage;


    @ManyToMany(mappedBy = "posts")
    private List<CategoryEntity> categories = new ArrayList<>();
}
