package com.shangqin.bms.utils;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.utils
 * @className：Response
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 10:24
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public class Response {
    private final static String STATUS_OK = "0";
    private final static String STATUS_ERROR = "1";
    private String status;
    private Object data;
    private Exception e;
    private String msg;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Exception getE() {
        return e;
    }
    public void setE(Exception e) {
        this.e = e;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Response() {
        super();
    }
    public Response(String status, Object data, Exception e, String msg) {
        super();
        this.status = status;
        this.data = data;
        this.e = e;
        this.msg = msg;
    }

    /**
     * 成功的结果
     * @param data 返回结果
     * @param msg  返回信息
     */
    public static Response newOkInstance(Object data, String msg) {
        return new Response(Response.STATUS_OK, data, null, msg);
    }

    /**
     * 成功的结果
     * @param data    返回结果
     */
    public  static  Response newOkInstance(Object data) {
        return new Response(Response.STATUS_OK, data, null, null);
    }

    /**
     * 失败的结果
     * @param msg  返回信息
     */
    public static Response newErrorInstance(String msg) {
        return new Response(Response.STATUS_ERROR, null, null, msg);
    }

    /**
     * 失败的结果
     * @param e       异常对象
     * @param msg  返回信息
     */
    public static Response newErrorInstance(Exception e, String msg) {
        return new Response(Response.STATUS_ERROR, null, e, msg);
    }
}
