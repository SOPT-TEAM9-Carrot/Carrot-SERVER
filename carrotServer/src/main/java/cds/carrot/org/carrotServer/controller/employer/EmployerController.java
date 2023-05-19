package cds.carrot.org.carrotServer.controller.employer;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.controller.employer.dto.response.EmployerResponseDto;
import cds.carrot.org.carrotServer.exception.BadRequestException;
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

    private final EmployerService employerService;

    private static final String AOS = "1";
    private static final String IOS = "2";
    private static final String AUTHORIZATION = "Authorization";

    @GetMapping("/{userId}/reviews")
    @ResponseStatus(HttpStatus.FOUND)
    public JsonResponse<EmployerResponseDto> getReviewList(HttpServletRequest request, @PathVariable Long userId, @RequestParam int size) {
        String auth = request.getHeader(AUTHORIZATION);
        if (!(AOS.equals(auth) || IOS.equals(auth))) {
            throw new BadRequestException(ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION, ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION.getMessage());
        }

        if (size < 0) {
            throw new BadRequestException(ErrorType.REQUEST_SIZE_EXCEPTION, ErrorType.REQUEST_SIZE_EXCEPTION.getMessage());
        }

        EmployerResponseDto responseDto = employerService.getUserWithReviews(userId, size);
        return JsonResponse.success(SuccessType.READ_REVIEW_LIST_SUCCESS, responseDto);
    }

}
