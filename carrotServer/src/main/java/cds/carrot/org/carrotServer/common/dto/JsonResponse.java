package cds.carrot.org.carrotServer.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonResponse<T> {

    private final int code;
    private final boolean success;
    private final String message;
    private T data;

    public static JsonResponse success(SuccessType success) {
        return new JsonResponse<>(success.getHttpStatusCode(), true, success.getMessage());
    }

    public static <T> JsonResponse<T> success(SuccessType success, T data) {
        return new JsonResponse<T>(success.getHttpStatusCode(), true, success.getMessage(), data);
    }

    public static JsonResponse error(ErrorType error) {
        return new JsonResponse<>(error.getHttpStatusCode(), false, error.getMessage());
    }

    public static JsonResponse error(ErrorType error, String message) {
        return new JsonResponse<>(error.getHttpStatusCode(), false, message);
    }
}