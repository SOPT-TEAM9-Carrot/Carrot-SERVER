package cds.carrot.org.carrotServer.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessType {
    /**
     * 200 OK
     */
    READ_REVIEW_LIST_SUCCESS(HttpStatus.OK, "알바 리스트 조회 성공"),
    READ_BOARD_LIST_SUCCESS(HttpStatus.OK, "게시물 리스트 조회를 성공했습니다."),
    READ_BOARD_RECOMMEND_SUCCESS(HttpStatus.OK, "추천 알바 리스트 조회를 성공했습니다."),
    READ_BOARD_SUCCESS(HttpStatus.OK, "게시물 상세 조회를 성공했습니다."),

    /**
     * 201 CREATED
     */
    CREATE_PROFILE_SUCCESS(HttpStatus.CREATED, "프로필 등록 성공"),
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
