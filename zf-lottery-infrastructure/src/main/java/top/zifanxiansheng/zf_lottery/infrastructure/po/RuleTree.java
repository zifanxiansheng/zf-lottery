package top.zifanxiansheng.zf_lottery.infrastructure.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class RuleTree implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 规则树Id
     */
    private String treeName;

    /**
     * 规则树描述
     */
    private String treeDesc;

    /**
     * 规则树根ID
     */
    private Long treeRootNodeId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}