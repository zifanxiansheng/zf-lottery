package top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.impl;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.strategy.annotation.StrategyModel;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.BaseLotteryAlgorithm;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 17:01
 **/
@Component
@StrategyModel(value = Constants.StrategyModelEnum.OVERALL)
public class OverAllRateRandomCalcAlgorithm extends BaseLotteryAlgorithm {


    @Override
    public String calc(Long strategyId, List<String> excludeAwardIds) {

        List<AwardRateInfo> awardRateList = getAwardRateList(strategyId);

        List<AwardRateInfo> availableAwardRateList = awardRateList.stream().filter(ar -> !excludeAwardIds.contains(ar.getAwardId())).collect(Collectors.toList());
        BigDecimal currentAwardRateDenominator = availableAwardRateList.stream()
                .reduce(BigDecimal.ZERO, (rateDenominator, a2) -> rateDenominator.add(a2.getAwardRate()), BigDecimal::add);

        if (availableAwardRateList.size() == 0) return null;
        if (availableAwardRateList.size() == 1) return availableAwardRateList.get(0).getAwardId();

        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100) + 1;
        String hitAwardId = null;
        int cursorVal = 0;

        for (AwardRateInfo rateInfo : availableAwardRateList) {
            int currentAwardRate = rateInfo.getAwardRate().divide(currentAwardRateDenominator, 2, BigDecimal.ROUND_UP).multiply(BigDecimal.valueOf(100L)).intValue();
            if (randomVal <= (currentAwardRate + cursorVal)) {
                hitAwardId = rateInfo.getAwardId();
                break;
            }
            cursorVal += currentAwardRate;
        }

        return hitAwardId;
    }
}
