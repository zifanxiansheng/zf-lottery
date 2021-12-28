package top.zifanxiansheng.zf_lottery.domain.activity.repository.impl;

import org.springframework.stereotype.Repository;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityInfo;
import top.zifanxiansheng.zf_lottery.domain.activity.repository.IActivityRepository;
import top.zifanxiansheng.zf_lottery.domain.activity.service.assembler.ActivityMapping;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.ActivityDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Activity;

import javax.annotation.Resource;

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
}
