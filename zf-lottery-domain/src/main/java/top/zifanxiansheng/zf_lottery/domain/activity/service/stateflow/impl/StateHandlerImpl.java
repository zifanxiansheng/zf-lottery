package top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.impl;

import org.springframework.stereotype.Service;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.common.Result;
import top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.AbstractStateHandler;
import top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.IStateHandler;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 14:56
 **/

@Service
public class StateHandlerImpl extends AbstractStateHandler implements IStateHandler {


    @Override
    public Result edit(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return super.edit(activityId, currentActivityState);
    }

    @Override
    public Result arraignment(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return super.arraignment(activityId, currentActivityState);
    }

    @Override
    public Result rollBack(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return super.rollBack(activityId, currentActivityState);
    }

    @Override
    public Result pass(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return super.pass(activityId, currentActivityState);
    }

    @Override
    public Result reject(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return super.reject(activityId, currentActivityState);
    }

    @Override
    public Result close(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return super.close(activityId, currentActivityState);
    }

    @Override
    public Result open(Long activityId, Constants.ActivityStateEnum currentActivityState) {
        return super.open(activityId, currentActivityState);
    }
}
