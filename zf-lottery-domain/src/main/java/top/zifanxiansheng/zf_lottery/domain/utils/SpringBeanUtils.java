package top.zifanxiansheng.zf_lottery.domain.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;

import java.lang.annotation.Annotation;
import java.util.Map;

@Component
@Slf4j
public class SpringBeanUtils implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T> void registerAnnotationMap(Class<? extends Annotation> annotationClass, Class<T> t, Map<? extends Constants.IPair, T> constMap) {
//        final Map<String, Object> beansMap = this.applicationContext.getBeansWithAnnotation(annotationClass);
//        beansMap.forEach((key, value) -> {
//            final Annotation annotation = AnnotationUtils.findAnnotation(value.getClass(), annotationClass);
//            if (t.isAssignableFrom(value.getClass())) {
//                try {
//                    assert annotation != null;
//                    final Method getMethod = annotation.getClass().getDeclaredMethod("value");
//                    final Constants.IPair keyEnum = (Constants.IPair) getMethod.invoke(annotation);
//                    constMap.put(keyEnum.get(), (T) value);
//                    log.info("自动注册策略类  key:{}, value: {}", annotation, key);
//                } catch (final Exception e) {
//                    log.error("自动注册策略类失败：", e);
//                }
//            }
//
//
//        });
    }
}
