package cds.carrot.org.carrotServer.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorType {

    /**
     * 400 BAD REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청값이 입력되지 않았습니다."),

    REQUEST_HEADER_TOKEN_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 헤더 토큰 값입니다."),
    REQUEST_SIZE_EXCEPTION(HttpStatus.BAD_REQUEST, "유효하지 않은 사이즈 값입니다. 사이즈는 음수일 수 없으며, 양의 정수이어야 합니다."),

    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_USER_EXCEPTION(HttpStatus.NOT_FOUND, "해당 사용자의 리뷰를 찾을 수 없습니다."),

    NOT_FOUND_POST_EXCEPTION(HttpStatus.NOT_FOUND, "해당 게시물을 찾을 수 없습니다."),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생하였습니다."),
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
