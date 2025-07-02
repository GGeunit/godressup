package com.godressup.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DressVO {
	private int id; // auto_increment
	private String name;
	private Integer price;
	private String size;
	private String color;
	private String image_url;
}
