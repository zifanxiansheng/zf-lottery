package top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.strategy.annotation.StrategyModel;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.BaseLotteryAlgorithm;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 17:46
 **/
@Component
@StrategyModel(strategyModel = Constants.StrategyModelEnum.SINGLE)
@Slf4j
public class SingleRateRandomCalcAlgorithm extends BaseLotteryAlgorithm {
    private final int HASH_INCREMENT = 0x61c88647; // 黄金分割线
    private final int RATE_TUPLE_LENGTH = 128;

    private final Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    @Override
    public void initRateInfoData(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        // init RATE_TUPLE_MAP
        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            int rateVal = awardRateInfo.getAwardRate().multiply(BigDecimal.valueOf(100)).intValue();
            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++)
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            cursorVal += rateVal;
        }

    }


    @Override
    public String calc(Long strategyId, List<String> excludeAwardIds) {

        String[] awardIds = rateTupleMap.get(strategyId);
        assert awardIds != null;
        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100) + 1;
        String awardId = awardIds[hashIdx(randomVal)];
        if (awardId == null) return null;
        if (excludeAwardIds.contains(awardId)) return null;
        return awardId;
    }

    @Override
    public boolean isExistRateInfoData(Long strategyId) {
        return rateTupleMap.isEmpty();
    }

    private int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }


}
