package top.zifanxiansheng.zf_lottery.domain.strategy.repository.impl;

import org.springframework.stereotype.Repository;
import top.zifanxiansheng.zf_lottery.common.assembler.IMapping;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardRateInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyDetailBrief;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyRich;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyRepository;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.StrategyDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.StrategyDetailDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Strategy;
import top.zifanxiansheng.zf_lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:41
 **/
@Repository
public class StrategyRepository implements IStrategyRepository {


    @Resource
    private StrategyDetailDAO strategyDetailDAO;

    @Resource
    private StrategyDAO strategyDAO;

    @Resource
    private IMapping<Strategy, StrategyBrief> strategyMapper;
    @Resource
    private IMapping<StrategyDetail, StrategyDetailBrief> strategyDetailMapper;

    @Override
    public List<AwardRateInfo> queryAwardRateListByStrategyId(Long strategyId) {

        List<StrategyDetail> strategyDetails = strategyDetailDAO.selectByKeySelective(StrategyDetail.builder().strategyId(strategyId).build());

        return strategyDetails.stream().map(sd -> AwardRateInfo.builder().awardId(sd.getAwardId())
                .awardRate(sd.getAwardRate())
                .strategyId(sd.getStrategyId())
                .build()).collect(Collectors.toList());
    }

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        List<Strategy> strategyList = strategyDAO.selectByKeySelective(Strategy.builder()
                .strategyId(strategyId).build());
        Strategy strategy = Objects.requireNonNull(strategyList).get(0);
        List<StrategyDetail> strategyDetails = strategyDetailDAO.selectByKeySelective(StrategyDetail.builder()
                .strategyId(strategyId).build());
        return StrategyRich.builder()
                .strategyId(strategyId)
                .strategyBrief(strategyMapper.sourceToTarget(strategy))
                .strategyDetailBriefList(strategyDetailMapper.sourceToTarget(strategyDetails.stream()))
                .build();
    }


}
