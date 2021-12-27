package top.zifanxiansheng.zf_lottery.domain.strategy.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRich {

    private Long strategyId;

    /**
     * 策略信息
     */
    private StrategyBrief strategyBrief;
    /**
     * 策略明细信息
     */
    private List<StrategyDetailBrief> strategyDetailBriefList;
}
