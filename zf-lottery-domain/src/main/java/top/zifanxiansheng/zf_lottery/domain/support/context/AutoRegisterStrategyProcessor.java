package top.zifanxiansheng.zf_lottery.domain.support.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import top.zifanxiansheng.zf_lottery.common.Constants;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 16:16
 **/
@Slf4j
public class AutoRegisterStrategyProcessor implements ApplicationContextAware {

    List<Class> annotationListClass;
    private ApplicationContext applicationContext;

    public AutoRegisterStrategyProcessor() {
    }


    public AutoRegisterStrategyProcessor(List<Class> annotationListClass) {
        this.annotationListClass = annotationListClass;

    }

    private void autoRegister(List<Class> iPairs, Map<Constants.IPair, Object> strategyContainer) {
        for (Class iPair : iPairs) {
            Class<? extends Annotation> clsA = (Class<? extends Annotation>) iPair;
            Map<String, Object> beansMap = applicationContext.getBeansWithAnnotation(clsA);

            beansMap.forEach((key, value) -> {
                try {
                    Annotation annotation = AnnotationUtils.findAnnotation(value.getClass(), clsA);
                    assert annotation != null;
                    Method getMethod = annotation.getClass().getDeclaredMethod("value");
                    Constants.IPair keyEnum = (Constants.IPair) getMethod.invoke(annotation);
                    strategyContainer.put(keyEnum.get(), value);
                    log.info("自动注册策略类  key:{}, value: {}", iPair, value.getClass().getSimpleName());

                } catch (Exception e) {
                    log.error("自动注册策略类失败：", e);
                }
            });


        }


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @PostConstruct
    public void init() {
        autoRegister(annotationListClass, LotteryContextHolder.getStrategyContextMap());
    }

}
