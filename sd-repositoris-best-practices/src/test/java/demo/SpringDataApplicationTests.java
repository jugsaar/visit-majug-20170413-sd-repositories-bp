package demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringDataApplication.class)
public class SpringDataApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		assertThat(applicationContext.containsBean("entityManagerFactory")).isTrue();
	}

}
