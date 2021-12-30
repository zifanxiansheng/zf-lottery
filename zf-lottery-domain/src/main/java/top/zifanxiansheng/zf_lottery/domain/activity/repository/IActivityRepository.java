package top.zifanxiansheng.zf_lottery.domain.activity.repository;

import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityInfo;

public interface IActivityRepository {


    int createActivity(ActivityInfo activityInfo);

    boolean alterActivityStatus(Long activityId, Constants.ActivityStateEnum currentState, Constants.ActivityStateEnum activityStateEnum);

}
