package top.zifanxiansheng.zf_lottery.domain.strategy.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.zifanxiansheng.zf_lottery.common.Constants;

import java.time.LocalDateTime;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:07
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardInfo {


    private String awardId;

    private String awardContent;

    private String awardName;
    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Constants.AwardTypeEnum awardType;

    /**
     * 策略方式（1:单项概率、2:总体概率）
     */
    private Constants.StrategyModelEnum strategyModel;

    /**
     * 发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
     */
    private Constants.GrantTypeEnum grantType;
    /**
     * 发奖时间
     */
    private LocalDateTime grantDate;

}
