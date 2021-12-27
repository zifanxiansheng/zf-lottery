package top.zifanxiansheng.zf_lottery.domain.strategy.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.zifanxiansheng.zf_lottery.common.Constants;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyBrief {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 策略描述
     */
    private String strategyDesc;

    /**
     * 策略方式（1:单项概率、2:总体概率）
     */
    private Constants.StrategyModelEnum strategyMode;

    /**
     * 发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
     */
    private Constants.GrantTypeEnum grantType;

    /**
     * 发放奖品时间
     */
    private LocalDateTime grantDate;

}
