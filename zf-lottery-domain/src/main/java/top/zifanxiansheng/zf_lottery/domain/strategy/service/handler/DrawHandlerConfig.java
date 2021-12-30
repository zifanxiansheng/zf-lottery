package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.LotteryAlgorithm;
import top.zifanxiansheng.zf_lottery.domain.utils.SpringBeanUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通过自定义注解，自动注册策略类型
 */
@Slf4j
@Component
public class DrawHandlerConfig {

    public static final Map<Constants.StrategyModelEnum, LotteryAlgorithm> LOTTERY_ALGORITHM_MAP = new ConcurrentHashMap<>();
    @Resource
    SpringBeanUtils springBeanUtils;

    @PostConstruct
    public void init() {
//        springBeanUtils.registerAnnotationMap(StrategyModel.class, LotteryAlgorithm.class, LOTTERY_ALGORITHM_MAP);

    }
}
