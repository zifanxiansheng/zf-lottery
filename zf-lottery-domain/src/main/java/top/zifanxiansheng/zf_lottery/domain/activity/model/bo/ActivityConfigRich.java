package top.zifanxiansheng.zf_lottery.domain.activity.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyBrief;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityConfigRich {
    private Long activityId;

    private Long strategyId;

    private ActivityInfo activityInfo;

    private List<AwardInfo> awardInfoList;

    private StrategyBrief strategyBrief;
}
