package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.System;

public class SystemException {
    private String whyException = "";
    private String whereException = "";

    public SystemException(String whyException, String whereException) {
        this.whyException = whyException;
        this.whereException = whereException;
    }

    public String getWhyException() {
        return whyException;
    }

    public void setWhyException(String whyException) {
        this.whyException = whyException;
    }

    public String getWhereException() {
        return whereException;
    }

    public void setWhereException(String whereException) {
        this.whereException = whereException;
    }
}
