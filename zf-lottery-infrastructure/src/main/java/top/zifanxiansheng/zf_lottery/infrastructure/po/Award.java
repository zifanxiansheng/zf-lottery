package top.zifanxiansheng.zf_lottery.infrastructure.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 奖品配置
 */
@Data
@Builder
public class Award implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 奖品ID
     */
    private String awardId;
    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Integer awardType;
    /**
     * 奖品名称
     */
    private String awardName;
    /**
     * 奖品内容「文字描述、Key、码」
     */
    private String awardContent;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}