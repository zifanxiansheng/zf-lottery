package top.zifanxiansheng.zf_lottery.domain.strategy.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 15:53
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardRateInfo {

    private Long strategyId;

    private BigDecimal awardRate;

    private String awardId;


}
