package cn.yang.springtest.jpa.test;

import cn.yang.springtest.jpa.dao.UserRepository;
import cn.yang.springtest.jpa.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void baseTest() throws Exception {
        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/application-jpa.xml");
        User user = new User();
        user.setName("Jay");
        user.setPassword("123456");
        user.setBirthday("2008-08-08");
        userRepository.save(user);
//        userRepository.delete(user);
//        userRepository.findOne(1);
    }
}
