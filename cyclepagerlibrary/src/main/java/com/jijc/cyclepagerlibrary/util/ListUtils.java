package com.jijc.cyclepagerlibrary.util;

import java.util.List;

/**
 * Description:List工具类
 * Created by jijc on 2016/12/22.
 * PackageName: com.jijc.cyclepagerlibrary.util
 */
public class ListUtils {
    /**
     * 获取LIST真实大小
     *
     * @param list
     * @return
     */
    public static int getSize(List list) {
        if (list == null || list.size() < 1) {
            return 0;
        } else {
            return list.size();
        }
    }
}
