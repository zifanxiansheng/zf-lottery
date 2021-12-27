package top.zifanxiansheng.zf_lottery.domain.award.service.distribute.impl;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.award.annotation.GoodType;
import top.zifanxiansheng.zf_lottery.domain.award.model.req.GoodsReq;
import top.zifanxiansheng.zf_lottery.domain.award.model.res.DistributeRes;
import top.zifanxiansheng.zf_lottery.domain.award.service.distribute.IDistributionGoods;

@Component
@GoodType(value = Constants.AwardTypeEnum.MATERIAL)
public class PhysicDistribution implements IDistributionGoods {
    @Override
    public DistributeRes distribute(GoodsReq req) {
        return null;
    }
}
