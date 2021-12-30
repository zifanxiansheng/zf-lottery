package top.zifanxiansheng.zf_lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.support.context.LotteryContextHolder;
import top.zifanxiansheng.zf_lottery.domain.support.ids.IDGenerator;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 11:27
 **/
@SpringBootApplication
@Configurable
@MapperScan(basePackages = "top.zifanxiansheng.zf_lottery.infrastructure")
public class LotteryApplication implements CommandLineRunner {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LotteryApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        // System.out.println(DrawHandlerConfig.LOTTERY_ALGORITHM_MAP.get(Constants.StrategyModelEnum.SINGLE));

        IDGenerator idGenerator = LotteryContextHolder.get(Constants.IdsEnum.ShortCode, IDGenerator.class);
        System.out.println(idGenerator.nextId());
    }
}
