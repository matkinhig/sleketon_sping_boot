package vn.com.vietbank.process;

import vn.com.vietbank.router.Request;
import vn.com.vietbank.router.Response;

public interface ProcessIpml<T extends Request, R extends Response> {
    public R run(T t) throws Exception;
}
