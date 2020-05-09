package cn.example.mp.test;

import cn.example.mp.test.entity.User;
import cn.example.mp.test.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {

		List<User> users = userMapper.selectList(null);

		Assert.assertEquals(4,users.size());
		users.forEach(System.out::println);
	}

}
