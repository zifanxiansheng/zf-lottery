package top.zifanxiansheng.zf_lottery.domain.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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
        Map<String, Object> beansMap = applicationContext.getBeansWithAnnotation(annotationClass);
        beansMap.entrySet().forEach(beanEntry -> {
            Annotation annotation = AnnotationUtils.findAnnotation(beanEntry.getValue().getClass(), annotationClass);
            if (t.isAssignableFrom(beanEntry.getValue().getClass())) try {
                Method getMethod = annotation.getClass().getDeclaredMethod("value");
                Constants.IPair keyEnum = (Constants.IPair) getMethod.invoke(annotation);
                constMap.put(keyEnum.get(), (T) beanEntry.getValue());
                log.info("自动注册策略类  key:{}, value: {}", annotation, beanEntry.getKey());
            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }
}
