package vn.com.vietbank.process;

import vn.com.vietbank.util.ResponseCode;

public class ProcessExc extends RuntimeException {
    private final ResponseCode reponseCode;

    public ProcessExc(String mess, ResponseCode respCode) {
        super(mess);
        this.reponseCode = respCode;
    }

    public ResponseCode getReponseCode() {
        return reponseCode;
    }
}
