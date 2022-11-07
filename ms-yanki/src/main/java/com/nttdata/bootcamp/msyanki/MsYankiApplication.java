package com.nttdata.bootcamp.msyanki;

import com.nttdata.bootcamp.msyanki.domain.PagoYanki;
import com.nttdata.bootcamp.msyanki.domain.Yanki;
import com.nttdata.bootcamp.msyanki.repository.PagoYankiRepository;
import com.nttdata.bootcamp.msyanki.repository.YankiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import reactor.core.publisher.Flux;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Swagger Demo", version = "1.0", description = "Documentation APIs v1.0"))
public class MsYankiApplication implements CommandLineRunner {

	@Autowired
	private YankiRepository repository;
	@Autowired
	private PagoYankiRepository repositoryPago;

	public static void main(String[] args) {
		SpringApplication.run(MsYankiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//repository.deleteAll();
		Flux.just(Yanki.builder().id("1").docNumber("17614375").cellNumber("987654321")
						.cellImei("123456789").email("nancy.tejada@gmail.com")
						.amountPurse(1500.00).build())
				.flatMap(p -> repository.save(p)).subscribe(p -> log.info("Insert: " + p.toString()));

		Flux.just(Yanki.builder().id("2").docNumber("74748041").cellNumber("996768401")
						.cellImei("123456789369852").email("angie.panaque.tejada.21@gmail.com")
						.accountAssociate(2).amountPurse(1269.3).build())
				.flatMap(p -> repository.save(p)).subscribe(p -> log.info("Insert: " + p.toString()));

		//INSERT DATA PAGO YANKI
		Flux.just(PagoYanki.builder().idTransmitter("1").idReceiver("2").amountSend(50.00).descriptionSend("transaccion ok").build())
				.flatMap(p2 -> repositoryPago.save(p2)).subscribe(p2 -> log.info("Insert Yanki Pago: " + p2.toString()));

		log.debug("run");
	}


	@Bean
	public ReactiveRedisTemplate<String, Yanki> reactiveJsonPostRedisTemplate(
			ReactiveRedisConnectionFactory connectionFactory) {

		RedisSerializationContext<String, Yanki> serializationContext = RedisSerializationContext
				.<String, Yanki>newSerializationContext(new StringRedisSerializer())
				.hashKey(new StringRedisSerializer())
				.hashValue(new Jackson2JsonRedisSerializer<>(Yanki.class))
				.build();


		return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
	}

	@Bean
	public ReactiveRedisTemplate<String, PagoYanki> reactiveJsonPostRedisTemplatePago(
			ReactiveRedisConnectionFactory connectionFactory) {

		RedisSerializationContext<String, PagoYanki> serializationContext = RedisSerializationContext
				.<String, PagoYanki>newSerializationContext(new StringRedisSerializer())
				.hashKey(new StringRedisSerializer())
				.hashValue(new Jackson2JsonRedisSerializer<>(PagoYanki.class))
				.build();


		return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
	}


}
