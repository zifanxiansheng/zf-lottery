package top.zifanxiansheng.zf_lottery.domain.activity.service.deploy.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityConfigRich;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityInfo;
import top.zifanxiansheng.zf_lottery.domain.activity.repository.IActivityRepository;
import top.zifanxiansheng.zf_lottery.domain.activity.service.deploy.IActivityDeploy;
import top.zifanxiansheng.zf_lottery.domain.award.repository.IAwardRepository;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyDetailBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyDetailRepository;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ActivityDeployImpl implements IActivityDeploy {
    @Resource
    private IActivityRepository activityRepository;
    @Resource
    private IAwardRepository awardRepository;
    @Resource
    private IStrategyRepository strategyRepository;
    @Resource
    private IStrategyDetailRepository strategyDetailRepository;

    @Transactional
    @Override
    public void createActivity(ActivityConfigRich req) {
        log.info("创建活动开始 activityId: {} strategyId: {}", req.getActivityId(), req.getStrategyId());
        ActivityInfo activityInfo = req.getActivityInfo();
        activityRepository.createActivity(activityInfo);

        List<AwardInfo> awardInfoList = req.getAwardInfoList();
        awardRepository.addAwardList(awardInfoList);

        StrategyBrief strategyBrief = req.getStrategyBrief();
        strategyRepository.saveStrategy(strategyBrief);

        List<StrategyDetailBrief> strategyDetailBriefList = strategyBrief.getStrategyDetailBriefList();
        strategyDetailRepository.saveStrategyDetails(strategyDetailBriefList);
        log.info("创建活动结束 activityId: {} strategyId: {}", req.getActivityId(), req.getStrategyId());

    }
}
