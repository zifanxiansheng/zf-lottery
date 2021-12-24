package top.zifanxiansheng.zf_lottery_infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.ActivityDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Activity;

import javax.annotation.Resource;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 14:28
 **/
@Slf4j
public class ActivityDAOTest extends BaseTest {

    @Resource
    ActivityDAO activityDAO;
    @Test
    public void test_activity_query() {
        Activity activity = activityDAO.selectByPrimaryKey(1L);

        String activityStr = JSON.toJSONString(activity);

        log.info(activityStr);
    }
}
