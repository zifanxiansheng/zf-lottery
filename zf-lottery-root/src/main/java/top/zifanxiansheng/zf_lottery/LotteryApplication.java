package top.zifanxiansheng.zf_lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 11:27
 **/
@SpringBootApplication
@MapperScan(basePackages = "top.zifanxiansheng.zf_lottery.infrastructure")
public class LotteryApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(LotteryApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // System.out.println(DrawHandlerConfig.LOTTERY_ALGORITHM_MAP.get(Constants.StrategyModelEnum.SINGLE));
    }
}
