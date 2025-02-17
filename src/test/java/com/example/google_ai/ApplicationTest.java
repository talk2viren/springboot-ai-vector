package com.example.google_ai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ApplicationTest {

	@Test
public void test1(){
		List<Employee> employeeList=new ArrayList<>();
		employeeList.add(new Employee(1,"afname","dLname"));
		employeeList.add(new Employee(6,"zfname","mLname"));
		employeeList.add(new Employee(8,"sfname","fLname"));
		employeeList.add(new Employee(2,"ffname","kLname"));
		employeeList.add(new Employee(3,"efname","hLname"));
		employeeList.add(new Employee(4,"ffname","pLname"));

		employeeList.stream()
				.sorted(Comparator.comparing((Employee e) ->e.fName())
						.thenComparing((Employee e) -> e.lName())
						.reversed()
				).forEach(System.out::println);
	}
	@Test
	public void test2(){
		String str="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sit nam officiis dolore nobis voluptates consectetur porro necessitatibus optio sint quae nesciunt sunt, amet nisi repudiandae repellat non libero suscipit explicabo. Quis architecto non dolores nisi necessitatibus dolore harum accusamus reprehenderit?";
		char[] charArray = str.toCharArray();

		Map<Character, Long> collect = IntStream.range(0, charArray.length)
				.mapToObj(x -> charArray[x])
				.filter(x -> x != ' ')
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		collect
				.entrySet()
				.stream()
				.sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
				.forEach(System.out::println);


	}

	@Test
	public void test3(){

		String body = RestClient.create("http://api.weatherapi.com/v1/current.json?key=a1249eca2a6646b796255106251502&q=Fremont")
				.get()
				.retrieve()
				.body(String.class);

		System.out.println(body);


	}


}

record Employee(Integer id,String fName,String lName){};