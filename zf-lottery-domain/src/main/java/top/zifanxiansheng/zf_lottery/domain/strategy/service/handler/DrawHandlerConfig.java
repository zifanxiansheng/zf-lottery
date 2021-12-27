package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.strategy.annotation.StrategyModel;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.LotteryAlgorithm;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通过自定义注解，自动注册策略类型
 */
@Slf4j
@Component
public class DrawHandlerConfig implements ApplicationContextAware {

    protected static final Map<Constants.StrategyModelEnum, LotteryAlgorithm> LOTTERY_ALGORITHM_MAP = new ConcurrentHashMap<>();
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {

        Map<String, Object> beansMap = applicationContext.getBeansWithAnnotation(StrategyModel.class);
        beansMap.entrySet().forEach(beanEntry -> {
            StrategyModel strategyModel = AnnotationUtils.findAnnotation(beanEntry.getValue().getClass(), StrategyModel.class);
            if (beanEntry.getValue() instanceof LotteryAlgorithm)
                LOTTERY_ALGORITHM_MAP.put(strategyModel.strategyModel(), (LotteryAlgorithm) beanEntry.getValue());
            log.info("strategyModel:{}, LotteryAlgorithm: {}", strategyModel, beanEntry.getKey());
        });

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
