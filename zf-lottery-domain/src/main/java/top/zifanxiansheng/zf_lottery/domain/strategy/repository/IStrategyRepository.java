package top.zifanxiansheng.zf_lottery.domain.strategy.repository;

import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyRich;

import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:55
 **/
public interface IStrategyRepository {

    /**
     * queryAwardRateListByStrategyId
     *
     * @param strategyId 策略ID
     * @return 奖品中奖概率集合
     */
    List<AwardRateInfo> queryAwardRateListByStrategyId(Long strategyId);

    /**
     * queryStrategyRich
     *
     * @param strategyId 策略ID
     * @return StrategyRich
     */
    StrategyRich queryStrategyRich(Long strategyId);

    AwardInfo queryAwardInfo(String awardId);


    StrategyBrief queryStrategy(Long strategyId);

    void saveStrategy(StrategyBrief strategyBrief);


}
