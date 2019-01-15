package tk.mybatis.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.springboot.FrontendJobApplication;
import tk.mybatis.springboot.model.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(FrontendJobApplication.class)
public class HttpAgentServiceImplTest {


    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test001() {
        JobDetailPojo pojo = new JobDetailPojo();
    }
}