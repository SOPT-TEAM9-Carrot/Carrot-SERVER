package cds.carrot.org.carrotServer.service.employer;

import cds.carrot.org.carrotServer.controller.employer.dto.response.EmployerResponseDto;

public interface EmployerService {

    EmployerResponseDto getUserWithReviews(Long userId, int size);
}
