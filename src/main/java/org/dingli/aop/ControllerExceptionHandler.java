package org.dingli.aop;

import org.dingli.common.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 定义全局异常类进行切面的操作,
 * 达到全局处理controller异常的效果
 *
 * @author Administrator
 */

@RestControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    // 这里就是通用的异常处理器了,所有预料之外的Exception异常都由这里处理
    @ExceptionHandler(NullPointerException.class)
    public CommonResult<String> nullExceptionHandler(Exception e) {
        String result = "有空指针异常，请求失败,请稍后再试";
        logger.error("application error", e);
        return CommonResult.failed(result);
    }

    @ExceptionHandler(Exception.class)
    public CommonResult<String> ExceptionHandler(Exception e) {
        String result = "有异常，请求失败,请稍后再试";
        logger.error("application error", e);
        return CommonResult.failed(result);
    }
}
