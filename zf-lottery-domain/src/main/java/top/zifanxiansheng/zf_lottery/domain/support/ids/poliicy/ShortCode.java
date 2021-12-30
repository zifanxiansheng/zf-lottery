package top.zifanxiansheng.zf_lottery.domain.support.ids.poliicy;

import org.springframework.stereotype.Component;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.support.ids.IDGenerator;
import top.zifanxiansheng.zf_lottery.domain.support.ids.annotation.Ids;

import java.util.Calendar;
import java.util.Random;

/**
 * @Author 梓樊先生
 * @Date 2021/12/30 14:20
 **/
@Component
@Ids(value = Constants.IdsEnum.ShortCode)
public class ShortCode implements IDGenerator {
    @Override
    public Long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数

        String idStr = String.valueOf(year - 2020) +
                hour +
                String.format("%02d", week) +
                day +
                String.format("%03d", new Random().nextInt(1000));
        return Long.parseLong(idStr);
    }
}
