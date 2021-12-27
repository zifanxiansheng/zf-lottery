package top.zifanxiansheng.zf_lottery.domain.award.service.facotry;

import org.springframework.stereotype.Service;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.award.service.distribute.IDistributionGoods;

@Service
public class DistributionGoodsFactory extends GoodsConfig {

    public IDistributionGoods getDistributionGoodsService(Constants.AwardTypeEnum awardTypeEnum) {
        return distributionGoodsMap.get(awardTypeEnum);
    }

}
