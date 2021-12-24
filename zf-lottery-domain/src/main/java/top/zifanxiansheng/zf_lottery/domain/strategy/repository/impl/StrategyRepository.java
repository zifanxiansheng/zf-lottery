package top.zifanxiansheng.zf_lottery.domain.strategy.repository.impl;

import org.springframework.stereotype.Repository;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyRepository;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.StrategyDetailDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:41
 **/
@Repository
public class StrategyRepository implements IStrategyRepository {


    @Resource
    private StrategyDetailDAO strategyDetailDAO;


    @Override
    public List<AwardRateInfo> queryAwardRateListByStrategyId(Long strategyId) {

        List<StrategyDetail> strategyDetails = strategyDetailDAO.selectByKeySelective(StrategyDetail.builder().strategyId(strategyId).build());

        return strategyDetails.stream().map(sd -> {
            return AwardRateInfo.builder().awardId(sd.getAwardId())
                    .awardRate(sd.getAwardRate())
                    .strategyId(sd.getStrategyId())
                    .build();
        }).collect(Collectors.toList());
    }


}
