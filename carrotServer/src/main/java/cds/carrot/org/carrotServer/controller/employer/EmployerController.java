package cds.carrot.org.carrotServer.controller.employer;

import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.service.employer.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping
    public JsonResponse getReviewList(@PathVariable Long userId, @RequestParam int size) {
        return JsonResponse.success(SuccessType.READ_JOB_LIST_SUCCESS, employerService.getUserWithReviews(userId, size));
    }

}
