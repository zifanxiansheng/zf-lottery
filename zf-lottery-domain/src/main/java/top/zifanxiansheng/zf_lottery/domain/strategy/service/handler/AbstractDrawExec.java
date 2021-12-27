package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler;

import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyRich;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.req.DrawExecReq;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.res.DrawExecRes;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.LotteryAlgorithm;

import java.util.List;

public abstract class AbstractDrawExec extends DrawExecSupport implements DrawExec {


    protected static void checkAndInit(Long strategyId, LotteryAlgorithm lotteryAlgorithm, List<AwardRateInfo> awardRateInfoList) {

        boolean existRateInfoData = lotteryAlgorithm.isExistRateInfoData(strategyId);
        if (existRateInfoData) return;
        lotteryAlgorithm.initRateInfoData(strategyId, awardRateInfoList);
    }

    @Override
    public DrawExecRes drawExec(DrawExecReq req) {

        StrategyRich strategyRich = queryStrategyRich(req.getStrategyId());
        StrategyBrief strategyBrief = strategyRich.getStrategyBrief();
        List<AwardRateInfo> awardRateInfos = queryAwardRateInfoList(req.getStrategyId());
        LotteryAlgorithm lotteryAlgorithm = DrawHandlerConfig.LOTTERY_ALGORITHM_MAP.get(strategyBrief.getStrategyMode());
        checkAndInit(req.getStrategyId(), lotteryAlgorithm, awardRateInfos);
        //TODO 执行对应策略的抽奖计算
        return null;
    }
}
