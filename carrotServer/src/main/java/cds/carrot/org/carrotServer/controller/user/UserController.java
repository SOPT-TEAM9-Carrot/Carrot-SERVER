package cds.carrot.org.carrotServer.controller.user;

import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.controller.user.dto.request.CreateUserProfileRequest;
import cds.carrot.org.carrotServer.controller.user.dto.response.CreateUserProfileResponse;
import cds.carrot.org.carrotServer.service.employer.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final EmployerService employerService;

    @PostMapping("/profile")
    public JsonResponse postUserProfile(@RequestBody CreateUserProfileRequest request) {
        CreateUserProfileResponse response = CreateUserProfileResponse.of(request);
        return JsonResponse.success(SuccessType.SIGNUP_SUCCESS, response);
    }
}
