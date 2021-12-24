package top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm;

import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 15:52
 **/
public class LotteryAlgorithmSupport {

    @Resource
    private IStrategyRepository strategyRepository;

    public List<AwardRateInfo> queryAwardRateList(Long strategyId) {

        return strategyRepository.queryAwardRateListByStrategyId(strategyId);

    }


}
