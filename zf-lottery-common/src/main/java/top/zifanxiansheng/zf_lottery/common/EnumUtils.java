package top.zifanxiansheng.zf_lottery.common;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 枚举工具类
 */
public class EnumUtils {


    public static <E> E getEnumByCode(Integer code, Class<E> eClass) {
        try {
            Method method = eClass.getDeclaredMethod("key");
            E[] enumConstants = eClass.getEnumConstants();
            return Arrays.stream(enumConstants).filter(e -> {
                Integer key;
                try {
                    key = (Integer) method.invoke(e);
                } catch (Exception ex) {
                    return false;
                }
                return key == code;
            }).findFirst().orElse(null);
        } catch (Exception ex) {
            return null;
        }
    }

}
