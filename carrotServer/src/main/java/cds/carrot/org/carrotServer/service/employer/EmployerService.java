package cds.carrot.org.carrotServer.service.employer;

import cds.carrot.org.carrotServer.controller.employer.dto.response.EmployerResponse;

public interface EmployerService {

    EmployerResponse getUserWithReviews(Long userId, int size);
}
