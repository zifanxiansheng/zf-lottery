package top.zifanxiansheng.zf_lottery.domain.activity.service.deploy;

import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityConfigRich;

public interface IActivityDeploy {
    /**
     * 创建活动
     *
     * @param req 请求信息
     */
    void createActivity(ActivityConfigRich req);

}
