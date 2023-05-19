package cds.carrot.org.carrotServer.common;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomInterceptor implements org.springframework.web.servlet.HandlerInterceptor {
    private static final String AOS = "1";
    private static final String IOS = "2";
    private static final String AUTHORIZATION = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader(AUTHORIZATION);
        if (!(AOS.equals(userId) || IOS.equals(userId))) {
            throw new BadRequestException(ErrorType.REQUEST_HEADER_TOKEN_EXCEPTION);
        }
        return true;
    }

}
