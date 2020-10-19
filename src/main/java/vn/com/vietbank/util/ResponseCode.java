package vn.com.vietbank.util;

public enum ResponseCode {
    UNKNOW_ERROR("503", "Unknown error");

    private final String code;
    private String message;

    private ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseCode setMessage(String message) {
        this.message = message;
        return this;
    }

    public static ResponseCode findByCode(String code) {
        for (ResponseCode type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return UNKNOW_ERROR;
    }
}
