package cds.carrot.org.carrotServer.controller.user.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserProfileRequest {

    private String name;

    @NotNull(message = "'phoneNumber'은 필수값입니다.")
    private String phoneNumber;

    @NotNull(message = "'gender'는 필수값입니다.")
    private Integer gender;

    @NotNull(message = "'birthYear'은 필수값입니다.")
    private Integer birthYear;

    private String introduction;
}
