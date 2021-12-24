package top.zifanxiansheng.zf_lottery.infrastructure.po;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class RuleTreeNode implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 规则树ID
     */
    private Integer treeId;

    /**
     * 节点类型；1子叶、2果实
     */
    private Integer nodeType;

    /**
     * 节点值[nodeType=2]；果实值
     */
    private String nodeValue;

    /**
     * 规则Key
     */
    private String ruleKey;

    /**
     * 规则描述
     */
    private String ruleDesc;

    private static final long serialVersionUID = 1L;
}