package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyRich;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyDetailRepository;
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
    @Resource
    private IStrategyDetailRepository strategyDetailRepository;

    public List<String> queryNoStockAwards(Long strategyId) {
        return strategyDetailRepository.queryNoStockAwards(strategyId);
    }

    public StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    public List<AwardRateInfo> queryAwardRateInfoList(Long strategyId) {
        List<AwardRateInfo> awardRateInfos = strategyRepository.queryAwardRateListByStrategyId(strategyId);
        return awardRateInfos;
    }

    public AwardInfo queryAwardRich(String awardId, Long strategyId) {
        AwardInfo awardInfo = strategyRepository.queryAwardInfo(awardId);
        StrategyBrief strategyBrief = strategyRepository.queryStrategy(strategyId);

        return AwardInfo.builder().grantDate(strategyBrief.getGrantDate())
                .strategyModel(strategyBrief.getStrategyMode())
                .grantType(strategyBrief.getGrantType())
                .awardName(awardInfo.getAwardName())
                .awardId(awardId)
                .awardContent(awardInfo.getAwardContent())
                .awardType(awardInfo.getAwardType())
                .build();
    }

    public boolean deductStock(Long strategyId, String awardId) {
        int count = strategyDetailRepository.deductStock(strategyId, awardId);
        return count == 1;
    }
}
