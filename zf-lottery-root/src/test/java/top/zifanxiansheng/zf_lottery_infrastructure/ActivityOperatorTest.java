package top.zifanxiansheng.zf_lottery_infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.common.Result;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityConfigRich;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityInfo;
import top.zifanxiansheng.zf_lottery.domain.activity.service.deploy.IActivityDeploy;
import top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.IStateHandler;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyDetailBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.algorithm.LotteryAlgorithm;
import top.zifanxiansheng.zf_lottery.domain.support.context.LotteryContextHolder;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 09:53
 **/
@Slf4j
public class ActivityOperatorTest extends BaseTest {


    @Resource
    IActivityDeploy activityDeploy;
    @Resource
    IStateHandler stateHandler;

    @Test
    public void deploy_activity_test() {

        ActivityConfigRich activityConfigRich = ActivityConfigRich.builder()
                .activityId(20000L)
                .activityInfo(ActivityInfo.builder()
                        .activityId(20000L)
                        .activityDesc("点赞转发免费送程序员鼠标垫")
                        .activityName("转发点赞")
                        .beginDateTime(LocalDateTime.of(2021, 12, 5, 12, 12))
                        .endDateTime(LocalDateTime.of(2022, 1, 22, 12, 12))
                        .state(Constants.ActivityStateEnum.EDIT.key())
                        .build())
                .awardInfoList(new ArrayList<AwardInfo>() {
                    private static final long serialVersionUID = -3207275779464378694L;

                    {
                        add(AwardInfo.builder().awardId("10").awardName("精品鼠标垫").awardType(Constants.AwardTypeEnum.MATERIAL).awardContent("赠送精品鼠标垫").build());
                        add(AwardInfo.builder().awardId("11").awardName("MAc PRO").awardType(Constants.AwardTypeEnum.MATERIAL).awardContent("mac pro 电脑").build());
                        add(AwardInfo.builder().awardId("12").awardName("京东E卡5000").awardType(Constants.AwardTypeEnum.COUPON).awardContent("5000京东E卡").build());
                    }
                })
                .strategyBrief(StrategyBrief.builder()
                        .strategyId(20000L)
                        .grantDate(LocalDateTime.of(2022, 1, 21, 12, 12))
                        .grantType(Constants.GrantTypeEnum.TIME_TASK)
                        .strategyDesc("")
                        .strategyMode(Constants.StrategyModelEnum.OVERALL)
                        .strategyDetailBriefList(new ArrayList<StrategyDetailBrief>() {
                            private static final long serialVersionUID = 7525307068479547843L;

                            {
                                add(StrategyDetailBrief.builder().strategyId(20000L).awardRate(new BigDecimal("0.25")).awardCount(200).awardId("10").awardName("精品鼠标垫").build());
                                add(StrategyDetailBrief.builder().strategyId(20000L).awardRate(new BigDecimal("0.35")).awardCount(1).awardId("11").awardName("MAc PRO").build());
                                add(StrategyDetailBrief.builder().strategyId(20000L).awardRate(new BigDecimal("0.50")).awardCount(300).awardId("12").awardName("京东E卡5000").build());
                            }
                        })
                        .build())
                .build();
        log.info("req: {}", JSON.toJSONString(activityConfigRich));
        activityDeploy.createActivity(activityConfigRich);
        log.info("创建完成");

    }

    @Test
    public void test_activity_alter_status() {
        Result res = Result.buildFailure();
        final Long activityId = 20000L;
        res = stateHandler.arraignment(activityId, Constants.ActivityStateEnum.EDIT);
        log.info("res: {}", JSON.toJSONString(res));
        res = stateHandler.pass(activityId, Constants.ActivityStateEnum.ARRAIGNMENT);
        log.info("res: {}", JSON.toJSONString(res));
        res = stateHandler.close(activityId, Constants.ActivityStateEnum.PASS);
        log.info("res: {}", JSON.toJSONString(res));
        res = stateHandler.open(activityId, Constants.ActivityStateEnum.CLOSE);
        log.info("res: {}", JSON.toJSONString(res));
        res = stateHandler.open(activityId, Constants.ActivityStateEnum.OPEN);
        log.info("res: {}", JSON.toJSONString(res));


    }

    @Test
    public void test_auto_register() {

        LotteryAlgorithm lotteryAlgorithm = LotteryContextHolder.get(Constants.StrategyModelEnum.OVERALL, LotteryAlgorithm.class);
        log.info(lotteryAlgorithm.toString());
    }
}
