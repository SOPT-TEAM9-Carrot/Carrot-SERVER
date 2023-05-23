package cds.carrot.org.carrotServer.controller.employer;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.controller.employer.dto.response.EmployerResponse;
import cds.carrot.org.carrotServer.domain.employer.Review;
import cds.carrot.org.carrotServer.exception.BadRequestException;
import cds.carrot.org.carrotServer.service.employer.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping("/{userId}/reviews")
    public JsonResponse<EmployerResponse> getReviewList(@PathVariable Long userId, @RequestParam(required = false) Integer size) {
        if (ObjectUtils.isEmpty(size)) {
            throw new BadRequestException(ErrorType.VALIDATION_REQUEST_MISSING_EXCEPTION);
        } else if (size < 0) {
            throw new BadRequestException(ErrorType.REQUEST_SIZE_EXCEPTION);
        }
        List<Review> reviews = employerService.getByUserId(userId);
        EmployerResponse response = EmployerResponse.of(employerService.getById(userId), reviews.subList(0, Math.min(size, reviews.size())));
        return JsonResponse.success(SuccessType.READ_REVIEW_LIST_SUCCESS, response);
    }

}
