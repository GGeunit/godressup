package com.godressup.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

// AOP 활성화
@EnableAspectJAutoProxy
// MyBatisConfig.java 설정을 포함
@Import(MyBatisConfig.class)
// 설정된 패키지에서 빈을 찾아 등록
@ComponentScan(basePackages = {"com.godressup.persistence", "com.godressup.service", "com.godressup.aop"})
public class RootConfig {

}
