package top.zifanxiansheng.zf_lottery.domain.activity.repository;

import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityInfo;

public interface IActivityRepository {


    int createActivity(ActivityInfo activityInfo);

}
