package cds.carrot.org.carrotServer.controller.user.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserProfileRequest {

    private String name;
    private String phoneNumber;
    private int gender;
    private int birthYear;
    private String introduction;
}
