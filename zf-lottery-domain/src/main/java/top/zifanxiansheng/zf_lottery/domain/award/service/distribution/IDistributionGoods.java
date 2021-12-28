package top.zifanxiansheng.zf_lottery.domain.award.service.distribution;

import top.zifanxiansheng.zf_lottery.domain.award.model.req.GoodsReq;
import top.zifanxiansheng.zf_lottery.domain.award.model.res.DistributeRes;

public interface IDistributionGoods {

    DistributeRes distribute(GoodsReq req);
}
