package work;

import java.io.Serializable;

public class JsonResponse<T> implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Boolean success = true;
    private String errorCode;
    private String errorMsg;
    private T data;

    public JsonResponse() {
    }


    public Boolean isSuccess() {
        return this.success;
    }

    public JsonResponse setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getErrorCode() {
        return null != this.errorCode && !"null".equals(this.errorCode) ? this.errorCode : "";
    }

    public JsonResponse setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return null != this.errorMsg && !"null".equals(this.errorMsg) ? this.errorMsg : "";
    }

    public JsonResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public JsonResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> JsonResponse<T> success(T data) {
        return (new JsonResponse()).setData(data);
    }

    public static <T> JsonResponse<T> success() {
        return (new JsonResponse()).setData((Object) null);
    }

    public static JsonResponse fail(String code, String message) {
        return (new JsonResponse()).setSuccess(false).setErrorCode(code).setErrorMsg(message);
    }

    public static JsonResponse fail(String message) {
        return (new JsonResponse()).setSuccess(false).setErrorMsg(message).setErrorCode("FALSE").setData("");
    }

    @Override
    public String toString() {
        return "JsonResponse{success=" + this.success + ", errorCode='" + this.errorCode + '\'' + ", errorMsg='" + this.errorMsg + '\'' + ", data=" + this.data + '}';
    }
}