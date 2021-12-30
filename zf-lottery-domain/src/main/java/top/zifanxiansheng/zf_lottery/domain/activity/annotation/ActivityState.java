package top.zifanxiansheng.zf_lottery.domain.activity.annotation;


import top.zifanxiansheng.zf_lottery.common.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author luoyong
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityState {

    Constants.ActivityStateEnum value() default Constants.ActivityStateEnum.EDIT;

}
