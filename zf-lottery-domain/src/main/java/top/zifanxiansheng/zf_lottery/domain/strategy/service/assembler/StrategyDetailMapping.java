package top.zifanxiansheng.zf_lottery.domain.strategy.service.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import top.zifanxiansheng.zf_lottery.common.assembler.IMapping;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyDetailBrief;
import top.zifanxiansheng.zf_lottery.infrastructure.po.StrategyDetail;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StrategyDetailMapping extends IMapping<StrategyDetail, StrategyDetailBrief> {

}
