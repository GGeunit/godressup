package com.godressup.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileVO {
	private int id; // AUTO_INCREMENT
	private int user_id; // UserVO의 ID(FK)
	private String nickname;
	private int age;
	private String region;
}
