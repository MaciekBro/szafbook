package pl.namiekko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import org.junit.Assert;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SzafbookApplication.class)
@WebAppConfiguration
public class SzafbookApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertEquals(true, true);
	}

}
