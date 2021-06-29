package by.htp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserCreationAspect {

		@After("execution(public void by.htp.les04.service.impl.UserServiceImpl.createUser(by.htp.finalproject.bean.User)))")
		public void afterCreateUserAdvice() {

			System.out.println("Create User");	
	}
}
