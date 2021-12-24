package top.zifanxiansheng.zf_lottery.domain.activity.service.algorithm.impl;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.domain.activity.service.algorithm.BaseLotteryAlgorithm;

import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 17:46
 **/
@Component
public class SingleRateRandomCalcAlgorithm extends BaseLotteryAlgorithm {
    @Override
    public String calc(Long strategyId, List<String> excludeAwardIds) {
        return super.calc(strategyId, excludeAwardIds);
    }


}
