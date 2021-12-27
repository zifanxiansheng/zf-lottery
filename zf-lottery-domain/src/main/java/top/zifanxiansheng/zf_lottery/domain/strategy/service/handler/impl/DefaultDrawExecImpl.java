package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.LotteryAlgorithm;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.handler.AbstractDrawExec;

import java.util.List;

@Service
@Slf4j
public class DefaultDrawExecImpl extends AbstractDrawExec {
    @Override
    protected String doCalc(LotteryAlgorithm lotteryAlgorithm, Long strategyId, List<String> excludeIds) {
        String awardId = lotteryAlgorithm.calc(strategyId, excludeIds);
        if (awardId == null)
            log.info("未中奖 strategyId:{} 算法:{}", strategyId, lotteryAlgorithm.getClass().getSimpleName());

        // 扣减库存
        boolean success = deductStock(strategyId, awardId);
        log.info("扣减库存成功 awardId: {} strategyId:{}", awardId, strategyId);
        return success ? awardId : null;
    }

    @Override
    protected List<String> queryNoStockAwardIds(Long strategyId) {
        return queryNoStockAwards(strategyId);
    }
}
