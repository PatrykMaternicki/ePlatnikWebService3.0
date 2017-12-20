package com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.System.SystemException;

public class NoResultExceptionLogger {
    SystemException exception;

    public static void setException(String whyException, String whereException) {
        new SystemException(whyException, whereException);
    }

}
