package top.zifanxiansheng.zf_lottery.domain.award.service.facotry;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.award.annotation.GoodType;
import top.zifanxiansheng.zf_lottery.domain.award.service.distribute.IDistributionGoods;
import top.zifanxiansheng.zf_lottery.domain.utils.SpringBeanUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GoodsConfig {


    private final Map<Constants.AwardTypeEnum, IDistributionGoods> distributionGoodsMap = new ConcurrentHashMap<>();
    @Resource
    SpringBeanUtils springBeanUtils;

    @PostConstruct
    public void init() {
        springBeanUtils.registerAnnotationMap(GoodType.class, IDistributionGoods.class, distributionGoodsMap);
    }
}