package top.zifanxiansheng.zf_lottery.domain.activity.service.stateflow;

import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.common.Result;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 11:00
 **/
public interface IStateHandler {


    Result edit(Long activityId, Constants.ActivityStateEnum currentActivityState);

    Result arraignment(Long activityId, Constants.ActivityStateEnum currentActivityState);

    Result rollBack(Long activityId, Constants.ActivityStateEnum currentActivityState);

    Result pass(Long activityId, Constants.ActivityStateEnum currentActivityState);

    Result reject(Long activityId, Constants.ActivityStateEnum currentActivityState);

    Result close(Long activityId, Constants.ActivityStateEnum currentActivityState);

    Result open(Long activityId, Constants.ActivityStateEnum currentActivityState);


}
