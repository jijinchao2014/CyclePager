package com.jijc.cyclepagerlibrary.util;

import java.util.List;

/**
 * Created by zhou on 14-3-17.
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
