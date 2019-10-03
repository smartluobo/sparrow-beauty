package com.chaomeis.sparrowbeauty.common;

import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    public ResultInfo handleException(Exception ex, HttpServletRequest request) {
        this.outputException(ex);
        return ResultInfo.newFailResultInfo("系统异常，请联系客服!");
    }

    /**
     * 输出异常
     * @param e
     */
    protected void outputException(Exception e) {
        LOGGER.error(e.getMessage(),e);
    }
}
