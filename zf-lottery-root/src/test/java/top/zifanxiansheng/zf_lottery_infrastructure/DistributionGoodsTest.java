package top.zifanxiansheng.zf_lottery_infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.award.model.req.GoodsReq;
import top.zifanxiansheng.zf_lottery.domain.award.model.res.DistributeRes;
import top.zifanxiansheng.zf_lottery.domain.award.service.distribution.IDistributionGoods;
import top.zifanxiansheng.zf_lottery.domain.award.service.facotry.DistributionGoodsFactory;

import javax.annotation.Resource;

/**
 * @Author 梓樊先生
 * @Date 2021/12/28 10:11
 **/
@Slf4j
public class DistributionGoodsTest extends BaseTest {

    @Resource
    DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void test_distribution_goods() {

        GoodsReq goodsReq = GoodsReq.builder().strategyId(10001L)
                .awardId("5")
                .awardName("Ipad")
                .awardContent("Ipad")
                .uId("zifan")
                .build();

        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(Constants.AwardTypeEnum.DESC);
        DistributeRes distributeRes = distributionGoodsService.distribute(goodsReq);
        log.info("distribution result: {}", JSON.toJSONString(distributeRes));

    }
}
