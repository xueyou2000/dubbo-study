package com.xueyou.studyproject.dubbo.common.utils;

/**
 * 字符串工具
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 12:32 下午
 */
public class StringUtil {

    private static final char UNDERLINE = '_';

    /**
     * 驼峰转下划线
     *
     * @param param 字符串
     * @param charType 转换类型, 2=转大写, 否则转小写
     */
    public static String camelToUnderline(String param, Integer charType) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
            }
            if (charType == 2) {
                sb.append(Character.toUpperCase(c));  //统一都转大写
            } else {
                sb.append(Character.toLowerCase(c));  //统一都转小写
            }


        }
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     */
    public static String camelToUnderline(String param) {
        return camelToUnderline(param, 1);
    }


    /**
     * 下划线转驼峰
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        boolean flag = false; // "_" 后转大写标志,默认字符前面没有"_"
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                flag = true;
                //标志设置为true,跳过
            } else {
                if (flag) {
                    //表示当前字符前面是"_" ,当前字符转大写
                    sb.append(Character.toUpperCase(param.charAt(i)));
                    flag = false;  //重置标识
                } else {
                    sb.append(Character.toLowerCase(param.charAt(i)));
                }
            }
        }
        return sb.toString();
    }


}
