package top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm;

import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;

import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 15:42
 **/
public interface LotteryAlgorithm {

    /**
     * 前置数据填充
     *
     * @param strategyId        策略ID
     * @param awardRateInfoList 奖品概率集合
     */
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    /**
     * 抽奖核心接口
     *
     * @param strategyId      策略ID
     * @param excludeAwardIds 风控、没有库存等等一些情况的奖品ID
     * @return 奖品ID
     */
    String calc(Long strategyId, List<String> excludeAwardIds);

    /**
     * 前置数据是否填充完成
     *
     * @param strategyId 策略ID
     * @return 是否
     */
    boolean isExistRateTuple(Long strategyId);
}
