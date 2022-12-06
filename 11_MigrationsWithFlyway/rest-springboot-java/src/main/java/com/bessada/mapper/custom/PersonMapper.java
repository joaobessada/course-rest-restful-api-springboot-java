package com.bessada.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.bessada.data.vo.v2.PersonVOv2;
import com.bessada.model.Person;

@Service
public class PersonMapper {
	public PersonVOv2 convertEntityToVo(Person person) {
		PersonVOv2 vo = new PersonVOv2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setGender(person.getGender());
		
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOv2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		//vo.setBirthDay(new Date());
		
		return entity;
	}
}
