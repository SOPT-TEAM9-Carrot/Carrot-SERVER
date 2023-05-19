package cds.carrot.org.carrotServer.domain.employer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Review {

    private String reviewerName;

    private String comment;

    private String imageUrl;

}
