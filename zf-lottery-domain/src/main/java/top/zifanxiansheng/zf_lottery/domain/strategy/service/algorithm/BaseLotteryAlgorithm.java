package top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm;

import top.zifanxiansheng.zf_lottery.domain.strategy.exception.NotImplementException;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 15:50
 **/
public abstract class BaseLotteryAlgorithm implements LotteryAlgorithm {


    private final Map<Long, List<AwardRateInfo>> awardRateListMap = new ConcurrentHashMap<>();

    @Override
    public void initRateInfoData(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateListMap.put(strategyId, awardRateInfoList);
    }

    @Override
    public String calc(Long strategyId, List<String> excludeAwardIds) {
        throw new NotImplementException();
    }

    @Override
    public boolean isExistRateInfoData(Long strategyId) {
        return awardRateListMap.containsKey(strategyId);
    }

    protected List<AwardRateInfo> getAwardRateList(Long strategyId) {
        return awardRateListMap.get(strategyId);
    }
}
