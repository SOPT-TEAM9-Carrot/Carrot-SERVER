package cds.carrot.org.carrotServer.controller.employer;

import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.controller.employer.dto.response.EmployerResponseDto;
import cds.carrot.org.carrotServer.service.employer.EmployerService;
import cds.carrot.org.carrotServer.service.employer.EmployerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employer")
public class EmployerController {
    private static final Logger logger = LoggerFactory.getLogger(EmployerServiceImpl.class);

    private final EmployerService employerService;

    @GetMapping("/{userId}/reviews")
    @ResponseStatus(HttpStatus.FOUND)
    public JsonResponse<EmployerResponseDto> getReviewList(HttpServletRequest request, @PathVariable Long userId, @RequestParam int size) {
        String auth = request.getHeader("Authorization");
        EmployerResponseDto responseDto = employerService.getUserWithReviews("1", userId, size);
        return JsonResponse.success(SuccessType.READ_REVIEW_LIST_SUCCESS, responseDto);
    }

}
