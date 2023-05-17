package cds.carrot.org.carrotServer.domain.review;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Review {

    private String reviewerName;

    private String comment;

    private String imageUrl;
}
