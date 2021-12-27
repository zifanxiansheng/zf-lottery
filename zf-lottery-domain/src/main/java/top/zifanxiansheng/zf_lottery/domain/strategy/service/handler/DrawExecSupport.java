package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyRich;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 抽奖数据支持
 */
@Component
public class DrawExecSupport {

    @Resource
    private IStrategyRepository strategyRepository;

    public StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    public List<AwardRateInfo> queryAwardRateInfoList(Long strategyId) {
        List<AwardRateInfo> awardRateInfos = strategyRepository.queryAwardRateListByStrategyId(strategyId);
        return awardRateInfos;
    }
}
