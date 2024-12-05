package com.firstSpringProject.learn_spring_framework.examples.c1;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MongoDBDataService implements DataService{

	@Override
	public int[] retrieveData() {
		return new int[] {11,22,33,44,55};
	}

}