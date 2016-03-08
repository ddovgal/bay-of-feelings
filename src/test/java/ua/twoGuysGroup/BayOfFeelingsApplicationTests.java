package ua.twoGuysGroup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.twoGuysGroup.bayOfFeelings.BayOfFeelingsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BayOfFeelingsApplication.class)
@WebAppConfiguration
public class BayOfFeelingsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
