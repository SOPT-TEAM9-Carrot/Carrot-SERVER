package cds.carrot.org.carrotServer.controller.employer;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.controller.employer.dto.response.EmployerResponseDto;
import cds.carrot.org.carrotServer.exception.BadRequestException;
import cds.carrot.org.carrotServer.service.employer.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public JsonResponse<EmployerResponseDto> getReviewList(@RequestHeader String authorization, @PathVariable Long userId, @RequestParam int size) {
        if (!("0".equals(authorization) || "1".equals(authorization))) {
            throw new BadRequestException(ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION, ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION.getMessage());
        }

        EmployerResponseDto responseDto = employerService.getUserWithReviews(userId, size);
        return JsonResponse.success(SuccessType.READ_REVIEW_LIST_SUCCESS, responseDto);

    }

}
