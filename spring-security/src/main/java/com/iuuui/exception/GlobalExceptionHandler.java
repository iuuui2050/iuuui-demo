package com.iuuui.exception;

import com.iuuui.base.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author iuuui
 * @date 2025/03/30 0116
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AccessDeniedException.class)
    public R handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        log.error("请求 {} 被拒绝", request.getRequestURI());
        return R.forbidden();
    }

    @ExceptionHandler(BusinessException.class)
    public R businessException(BusinessException e) {
        e.printStackTrace();
        log.error("服务器发生业务异常：{}", e.getMessage());
        return R.error(e.getMessage());
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public R runtimeException(RuntimeException e) {
        e.printStackTrace();
        log.error("服务器发生未知异常：{}", e.getMessage());
        return R.error("服务器发生未知异常");
    }


}
