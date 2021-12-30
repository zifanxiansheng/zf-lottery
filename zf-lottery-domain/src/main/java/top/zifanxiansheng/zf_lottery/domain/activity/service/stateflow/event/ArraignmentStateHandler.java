package top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Service;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.common.Result;
import top.zifanxiansheng.zf_lottery.domain.activity.annotation.ActivityState;
import top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.AbstractStateHandler;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 11:24
 **/
@ActivityState(value = Constants.ActivityStateEnum.ARRAIGNMENT)
@Service
public class ArraignmentStateHandler extends AbstractStateHandler {
    @Override
    public Result edit(Long activityId, Constants.ActivityStateEnum currentState) {
        return Result.buildFailure("提审状态不可编辑");
    }

    @Override
    public Result arraignment(Long activityId, Constants.ActivityStateEnum currentState) {
        return Result.buildFailure("不可重复提审");
    }

    @Override
    public Result rollBack(Long activityId, Constants.ActivityStateEnum currentState) {
        boolean success = activityRepository.alterActivityStatus(activityId, currentState, Constants.ActivityStateEnum.ROLLBACK);
        return success ? Result.buildSuccess("撤审成功") : Result.buildFailure("撤审失败");
    }

    @Override
    public Result pass(Long activityId, Constants.ActivityStateEnum currentState) {
        boolean success = activityRepository.alterActivityStatus(activityId, currentState, Constants.ActivityStateEnum.PASS);
        return success ? Result.buildSuccess("操作成功   ") : Result.buildFailure("pass 失败");
    }

    @Override
    public Result reject(Long activityId, Constants.ActivityStateEnum currentState) {
        boolean success = activityRepository.alterActivityStatus(activityId, currentState, Constants.ActivityStateEnum.REJECT);
        return success ? Result.buildSuccess("操作成功") : Result.buildFailure("reject 失败");
    }

    @Override
    public Result close(Long activityId, Constants.ActivityStateEnum currentState) {
        return Result.buildFailure("审核状态不可关闭");
    }

    @Override
    public Result open(Long activityId, Constants.ActivityStateEnum currentState) {
        return Result.buildFailure("审核状态不可开启");
    }
}
