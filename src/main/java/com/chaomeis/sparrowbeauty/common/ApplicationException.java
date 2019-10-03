package com.chaomeis.sparrowbeauty.common;

import java.io.Serializable;

public class ApplicationException extends Exception implements Serializable {
    private String code;
    private String desc;
    public ApplicationException(ResponseCodeDesc responseCodeDesc){
        this.code = responseCodeDesc.getCode();
        this.desc = responseCodeDesc.getDesc();
    }

    public ApplicationException(String code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
