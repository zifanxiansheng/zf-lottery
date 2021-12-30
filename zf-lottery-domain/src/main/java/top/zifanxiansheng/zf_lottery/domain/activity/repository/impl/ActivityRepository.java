package top.zifanxiansheng.zf_lottery.domain.activity.repository.impl;

import org.springframework.stereotype.Repository;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityInfo;
import top.zifanxiansheng.zf_lottery.domain.activity.repository.IActivityRepository;
import top.zifanxiansheng.zf_lottery.domain.activity.service.assembler.ActivityMapping;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.ActivityDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Activity;

import javax.annotation.Resource;
import java.util.HashMap;

@Repository
public class ActivityRepository implements IActivityRepository {
    @Resource
    ActivityDAO activityDAO;
    @Resource
    ActivityMapping activityMapping;

    @Override
    public int createActivity(ActivityInfo activityInfo) {

        Activity activity = activityMapping.sourceToTarget(activityInfo);
        int count = activityDAO.insert(activity);
        return count;
    }

    @Override
    public boolean alterActivityStatus(Long activityId, Constants.ActivityStateEnum currentState, Constants.ActivityStateEnum activityStateEnum) {

        return 1 == activityDAO.alterActivityState(new HashMap<String, Object>() {
            private static final long serialVersionUID = -4836855007974080477L;

            {
                put("beforeState", currentState.key());
                put("afterState", activityStateEnum.key());
                put("activityId", activityId);
        }});
    }
}
