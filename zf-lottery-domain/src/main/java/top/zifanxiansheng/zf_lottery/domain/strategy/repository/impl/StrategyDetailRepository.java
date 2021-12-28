package top.zifanxiansheng.zf_lottery.domain.strategy.repository.impl;

import org.springframework.stereotype.Repository;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyDetailBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyDetailRepository;
import top.zifanxiansheng.zf_lottery.domain.strategy.service.assembler.StrategyDetailMapping;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.StrategyDetailDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:41
 **/
@Repository
public class StrategyDetailRepository implements IStrategyDetailRepository {


    @Resource
    private StrategyDetailDAO strategyDetailDAO;
    @Resource
    private StrategyDetailMapping strategyDetailMapping;


    @Override
    public int deductStock(Long strategyId, String awardId) {
        return strategyDetailDAO.deductStock(StrategyDetail.builder().strategyId(strategyId).awardId(awardId).build());
    }

    @Override
    public List<String> queryNoStockAwards(Long strategyId) {
        List<StrategyDetail> strategyDetails = strategyDetailDAO.selectByKeySelective(StrategyDetail.builder().strategyId(strategyId).awardSurplusCount(0).build());
        if (strategyDetails.isEmpty()) return new ArrayList<>();
        return strategyDetails.stream().map(StrategyDetail::getAwardId).collect(Collectors.toList());
    }

    @Override
    public void saveStrategyDetails(List<StrategyDetailBrief> strategyDetailBriefList) {

        for (StrategyDetailBrief strategyDetailBrief : strategyDetailBriefList) {
            StrategyDetail strategyDetail = strategyDetailMapping.targetToSource(strategyDetailBrief);
            strategyDetailDAO.insert(strategyDetail);
        }

    }
}
