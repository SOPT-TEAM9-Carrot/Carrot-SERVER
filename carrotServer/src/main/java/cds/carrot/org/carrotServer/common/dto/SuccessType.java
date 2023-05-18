package cds.carrot.org.carrotServer.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessType {
    /**
     * 200 OK
     */
    READ_JOB_LIST_SUCCESS(HttpStatus.FOUND, "알바 리스트 조회 성공"),

    /**
     * 201 CREATED
     */
    CREATE_PROFILE_SUCCESS(HttpStatus.CREATED, "프로필 등록 성공")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getMessage() {
        return message;
    }
}
