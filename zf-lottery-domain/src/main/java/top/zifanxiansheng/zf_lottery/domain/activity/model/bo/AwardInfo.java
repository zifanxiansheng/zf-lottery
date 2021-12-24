package top.zifanxiansheng.zf_lottery.domain.activity.model.bo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:07
 **/
@Data
@Builder
public class AwardInfo {

    private Long strategyId;

    private BigDecimal awardRate;

    private String awardId;


    private String awardContent;

    private byte  awardType;
}
