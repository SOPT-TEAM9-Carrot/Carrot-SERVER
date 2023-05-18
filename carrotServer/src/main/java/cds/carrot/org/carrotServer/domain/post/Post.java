package cds.carrot.org.carrotServer.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Post {

    private String company;

    private String title;

    private String content;

    private String imageUrl;

    private String address;

    private int hourlyWage;

    private int monthlyWage;

    private List<Category> categories = new ArrayList<>();
}

