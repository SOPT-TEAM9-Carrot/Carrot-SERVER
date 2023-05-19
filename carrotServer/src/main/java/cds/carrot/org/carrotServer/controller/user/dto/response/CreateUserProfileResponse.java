package cds.carrot.org.carrotServer.controller.user.dto.response;

import cds.carrot.org.carrotServer.controller.user.dto.request.CreateUserProfileRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserProfileResponse {

    private String name;
    private String phoneNumber;
    private int gender;
    private int birthYear;
    private String introduction;

    public static CreateUserProfileResponse of (CreateUserProfileRequest request) {
        return CreateUserProfileResponse.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .birthYear(request.getBirthYear())
                .introduction(request.getIntroduction())
                .build();
    }
    public static CreateUserProfileResponse newInstance(
            String name,
            String phoneNumber,
            int gender,
            int birthYear,
            String introduction
    ) {
        return CreateUserProfileResponse.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .birthYear(birthYear)
                .introduction(introduction)
                .build();
    }
}