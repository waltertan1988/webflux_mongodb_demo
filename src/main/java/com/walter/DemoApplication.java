package com.walter;

import com.walter.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableReactiveMongoRepositories(basePackages = {"com.walter.repository"})
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

        PersonService personService = applicationContext.getBean(PersonService.class);
        Scheduler scheduler = Schedulers.newParallel("", 3);
        personService.listAll().parallel().runOn(scheduler).doOnComplete(() -> scheduler.dispose()).subscribe(person -> System.out.println(person));
	}
}
