package cds.carrot.org.carrotServer.service.employer;

import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.domain.employer.User;

import java.util.List;

public interface EmployerService {

    List<Review> getByUserId(Long userId);

    User getById(Long userId);
}
