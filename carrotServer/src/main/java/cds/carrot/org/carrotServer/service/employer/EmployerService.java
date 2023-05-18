package cds.carrot.org.carrotServer.service.employer;

import cds.carrot.org.carrotServer.domain.employer.User;

public interface EmployerService {

    User getUserWithReviews(Long userId, int size);
}
