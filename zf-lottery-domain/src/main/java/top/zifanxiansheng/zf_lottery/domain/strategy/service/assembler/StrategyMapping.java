package top.zifanxiansheng.zf_lottery.domain.strategy.service.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import top.zifanxiansheng.zf_lottery.common.assembler.IMapping;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Strategy;
import top.zifanxiansheng.zf_lottery.common.Constants.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StrategyMapping extends IMapping<Strategy, StrategyBrief> {

    @Mapping(target = "grantType", expression = "java(top.zifanxiansheng.zf_lottery.common.EnumUtils.getEnumByCode(var1.getGrantType(), top.zifanxiansheng.zf_lottery.common.Constants.GrantTypeEnum.class))")
    @Mapping(target = "strategyMode", expression = "java(top.zifanxiansheng.zf_lottery.common.EnumUtils.getEnumByCode(var1.getStrategyMode(),top.zifanxiansheng.zf_lottery.common.Constants.StrategyModelEnum.class))")
    @Override
    StrategyBrief sourceToTarget(Strategy var1);

    @Override
    Strategy targetToSource(StrategyBrief var1);

    default int map(StrategyModelEnum var1) {
        return var1.key();
    }

    default int map2(GrantTypeEnum var1) {
        return var1.key();
    }

}
