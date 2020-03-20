package com.shangqin.bms.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.utils
 * @className：SessionUtil
 * @createAuthor：zhouyang
 * @createTime：2020/3/20 18:37
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public class SessionUtil {
    public static Integer getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map userMap = (HashMap)session.getAttribute("userMap");
        Integer userId = (Integer) userMap.get("userId");
        return userId;
    }
}
