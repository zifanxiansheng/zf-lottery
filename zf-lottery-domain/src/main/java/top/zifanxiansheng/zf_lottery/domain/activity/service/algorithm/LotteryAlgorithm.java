package top.zifanxiansheng.zf_lottery.domain.activity.service.algorithm;

import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 15:42
 **/
public interface LotteryAlgorithm {

    /**
     *  抽奖核心接口
     * @param strategyId 策略ID
     * @param excludeAwardIds 风控、没有库存等等一些情况的奖品ID
     * @return 奖品ID
     */
    public String calc(Long strategyId, List<String> excludeAwardIds) ;
}
