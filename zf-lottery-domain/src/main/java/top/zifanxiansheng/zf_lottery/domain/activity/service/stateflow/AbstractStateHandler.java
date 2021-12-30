package top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow;

import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.common.Result;
import top.zifanxiansheng.zf_lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 11:25
 **/
public abstract class AbstractStateHandler extends StateConfig {
    @Resource
    protected IActivityRepository activityRepository;


    public Result edit(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return StateConfig.ACTIVITY_STATE_HANDLER_MAP.get(currentActivityState).edit(activityId, currentActivityState);
    }


    public Result arraignment(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return StateConfig.ACTIVITY_STATE_HANDLER_MAP.get(currentActivityState).arraignment(activityId, currentActivityState);
    }


    public Result rollBack(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return StateConfig.ACTIVITY_STATE_HANDLER_MAP.get(currentActivityState).rollBack(activityId, currentActivityState);
    }


    public Result pass(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return StateConfig.ACTIVITY_STATE_HANDLER_MAP.get(currentActivityState).pass(activityId, currentActivityState);
    }


    public Result reject(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return StateConfig.ACTIVITY_STATE_HANDLER_MAP.get(currentActivityState).reject(activityId, currentActivityState);
    }


    public Result close(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return StateConfig.ACTIVITY_STATE_HANDLER_MAP.get(currentActivityState).close(activityId, currentActivityState);
    }


    public Result open(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return StateConfig.ACTIVITY_STATE_HANDLER_MAP.get(currentActivityState).open(activityId, currentActivityState);
    }
}
