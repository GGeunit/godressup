package com.godressup.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private int id; // auto_increment
	private String username; // ID
	private String password; // PW
	private String email;
}
