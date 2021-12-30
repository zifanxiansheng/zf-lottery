package top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Service;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.common.Result;
import top.zifanxiansheng.zf_lottery.domain.activity.annotation.ActivityState;
import top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow.AbstractStateHandler;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 11:26
 **/
@ActivityState(value = Constants.ActivityStateEnum.REJECT)
@Service
public class RejectStateHandler extends AbstractStateHandler {
    @Override
    public Result edit(Long activityId, Constants.ActivityStateEnum state) {
        return Result.buildFailure("拒绝状态不能编辑");
    }

    @Override
    public Result arraignment(Long activityId, Constants.ActivityStateEnum state) {
        return Result.buildFailure("拒绝状态不能提审");
    }

    @Override
    public Result rollBack(Long activityId, Constants.ActivityStateEnum state) {
        boolean success = activityRepository.alterActivityStatus(activityId, state, Constants.ActivityStateEnum.ROLLBACK);
        return success ? Result.buildSuccess() : Result.buildFailure("操作失败");
    }

    @Override
    public Result pass(Long activityId, Constants.ActivityStateEnum state) {
        return Result.buildFailure("拒绝状态不能通过");
    }

    @Override
    public Result reject(Long activityId, Constants.ActivityStateEnum state) {
        return Result.buildFailure("不能重复拒绝");

    }

    @Override
    public Result close(Long activityId, Constants.ActivityStateEnum state) {
        return Result.buildFailure("不能重复关闭");

    }

    @Override
    public Result open(Long activityId, Constants.ActivityStateEnum state) {
        return Result.buildFailure("拒绝状态不能开启");

    }
}
