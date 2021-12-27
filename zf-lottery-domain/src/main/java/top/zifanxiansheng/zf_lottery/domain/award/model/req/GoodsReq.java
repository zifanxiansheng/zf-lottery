package top.zifanxiansheng.zf_lottery.domain.award.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReq {

    private String uId;
    private String awardId;
    private String awardName;
    private String awardContent;
    private Long strategyId;
    private Long orderId;


}
