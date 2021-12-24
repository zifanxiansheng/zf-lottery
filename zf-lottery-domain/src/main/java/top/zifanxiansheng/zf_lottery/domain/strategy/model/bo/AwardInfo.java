package top.zifanxiansheng.zf_lottery.domain.strategy.model.bo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:07
 **/
@Data
@Builder
public class AwardInfo {


    private String awardId;

    private String awardContent;
    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private byte awardType;

    /**
     * 策略方式（1:单项概率、2:总体概率）
     */
    private Integer strategyModel;

    /**
     * 发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
     */
    private Integer grantType;
    /**
     * 发奖时间
     */
    private Date grantDate;

}
