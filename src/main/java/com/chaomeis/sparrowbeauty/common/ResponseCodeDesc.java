package com.chaomeis.sparrowbeauty.common;

public enum ResponseCodeDesc {
    //前面2位：后台B0  前台F0   公共:00
    // 中间2位功能编号：00公共  01 会员   02 商品  03 活动  04 订单 05 分类 06 营销 07文章 08 支付 09快递地址
    //后面2位：错误码
    SUCCESS("000000","成功"),
    SYSTEM_ERROR("100000","系统错误"),
    CANNOT_FIND_ERROR_CODE("000004","未能找到正确的错误类型"),
    ;

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 取得返回状态信息
     * @param code  状态码
     * @return
     */
    public static ResponseCodeDesc getResponseCodeDesc(String code){

        if(code == null || code.length() == 0){
            return CANNOT_FIND_ERROR_CODE;
        }

        for(ResponseCodeDesc codeDesc : ResponseCodeDesc.values()){
            if(code.equals(codeDesc.getCode())){
                return codeDesc;
            }
        }

        return CANNOT_FIND_ERROR_CODE;
    }


    private ResponseCodeDesc(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String value(){
        return this.code;
    }
}
