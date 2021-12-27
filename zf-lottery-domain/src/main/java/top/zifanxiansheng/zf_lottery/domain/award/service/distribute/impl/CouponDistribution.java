package top.zifanxiansheng.zf_lottery.domain.award.service.distribute.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.award.annotation.GoodType;
import top.zifanxiansheng.zf_lottery.domain.award.model.req.GoodsReq;
import top.zifanxiansheng.zf_lottery.domain.award.model.res.DistributeRes;
import top.zifanxiansheng.zf_lottery.domain.award.service.distribute.DistributioneBase;
import top.zifanxiansheng.zf_lottery.domain.award.service.distribute.IDistributionGoods;

@Component
@GoodType(value = Constants.AwardTypeEnum.COUPON)
@Slf4j
public class CouponDistribution extends DistributioneBase implements IDistributionGoods {
    @Override
    public DistributeRes distribute(GoodsReq req) {
        log.info("模拟优惠劵发放接口： uid:{} awardContent: {}", req.getUId(), req.getAwardContent());
        super.updateAwardState(req.getUId(), req.getOrderId(), Constants.AwardStateEnum.SUCCESS.key(), req.getAwardId());
        return DistributeRes.builder().uId(req.getUId()).code(Constants.AwardStateEnum.SUCCESS.key()).info(Constants.AwardStateEnum.SUCCESS.value()).build();
    }
}
