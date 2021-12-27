package top.zifanxiansheng.zf_lottery.domain.strategy.service.handler;

import lombok.extern.slf4j.Slf4j;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyRich;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.req.DrawExecReq;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.res.DrawExecRes;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.LotteryAlgorithm;

import java.util.List;

@Slf4j
public abstract class AbstractDrawExec extends DrawExecSupport implements DrawExec {


    protected static void checkAndInit(Long strategyId, LotteryAlgorithm lotteryAlgorithm, List<AwardRateInfo> awardRateInfoList) {

        boolean existRateInfoData = lotteryAlgorithm.isExistRateInfoData(strategyId);
        if (existRateInfoData) return;
        lotteryAlgorithm.initRateInfoData(strategyId, awardRateInfoList);
    }

    private DrawExecRes buildResult(String awardId, Long strategyId) {
        if (awardId == null)
            return DrawExecRes.builder().drawState(Constants.DrawStateEnum.FAILURE).strategyId(strategyId).build();

        AwardInfo awardInfo = queryAwardRich(awardId, strategyId);
        DrawExecRes drawExecRes = DrawExecRes.builder().drawState(Constants.DrawStateEnum.SUCCESS)
                .strategyId(strategyId)
                .awardInfo(awardInfo)
                .awardName(awardInfo.getAwardName())
                .build();
        log.info("抽奖结果 awardId: {}, awardState: {} strategyId: {} awardName: {}", awardId, drawExecRes.getDrawState().value(), strategyId, awardInfo.getAwardName());
        return drawExecRes;

    }

    @Override
    public DrawExecRes drawExec(DrawExecReq req) {
        log.info("抽奖开始 strategyId: {} 用户: {}", req.getStrategyId(), req.getUId());
        StrategyRich strategyRich = queryStrategyRich(req.getStrategyId());
        StrategyBrief strategyBrief = strategyRich.getStrategyBrief();
        List<AwardRateInfo> awardRateInfos = queryAwards(req.getStrategyId());
        LotteryAlgorithm lotteryAlgorithm = DrawHandlerConfig.LOTTERY_ALGORITHM_MAP.get(strategyBrief.getStrategyMode());
        checkAndInit(req.getStrategyId(), lotteryAlgorithm, awardRateInfos);
        String awardId = doCalc(lotteryAlgorithm, strategyBrief.getStrategyId(), queryNoStockAwardIds(strategyBrief.getStrategyId()));
        return buildResult(awardId, req.getStrategyId());
    }

    protected abstract String doCalc(LotteryAlgorithm lotteryAlgorithm, Long strategyId, List<String> excludeIds);

    protected List<AwardRateInfo> queryAwards(Long strategyId) {
        return queryAwardRateInfoList(strategyId);
    }

    protected abstract List<String> queryNoStockAwardIds(Long strategyId);
}
