package cds.carrot.org.carrotServer.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access =  AccessLevel.PRIVATE)
public enum SuccessType {

    /**
     * 201 CREATED
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료됐습니다."),
    CREATE_BOARD_SUCCESS(HttpStatus.CREATED, "게시물 생성이 완료됐습니다."),

    READ_BOARD_LIST_SUCCESS(HttpStatus.OK, "게시물 리스트 조회를 성공했습니다."),
    READ_BOARD_RECOMMEND_SUCCESS(HttpStatus.OK, "추천 알바 리스트 조회를 성공했습니다."),
    READ_BOARD_SUCCESS(HttpStatus.OK, "게시물 상세 조회를 성공했습니다."),
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
