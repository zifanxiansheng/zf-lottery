package top.zifanxiansheng.zf_lottery.domain.award.annotation;

import top.zifanxiansheng.zf_lottery.common.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GoodType {
    Constants.AwardTypeEnum value() default Constants.AwardTypeEnum.DESC;
}
