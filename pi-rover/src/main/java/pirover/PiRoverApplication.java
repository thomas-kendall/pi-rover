package pirover;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import pirover.service.Rover;

@SpringBootApplication
@EnableAsync
public class PiRoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiRoverApplication.class, args);
	}

	@Bean
	public CommandLineRunner schedulingRunner(TaskExecutor executor, Rover rover) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				executor.execute(rover);
			}
		};

	}
}
