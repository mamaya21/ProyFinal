package com.nttdata.bootcamp.msp2p;

import com.nttdata.bootcamp.msp2p.domain.PagoP2P;
import com.nttdata.bootcamp.msp2p.domain.P2P;
import com.nttdata.bootcamp.msp2p.repository.PagoP2PRepository;
import com.nttdata.bootcamp.msp2p.repository.P2PRepository;
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
public class Msp2pApplication implements CommandLineRunner {

	@Autowired
	private P2PRepository repository;
	@Autowired
	private PagoP2PRepository repositoryPago;

	public static void main(String[] args) {
		SpringApplication.run(Msp2pApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//repository.deleteAll();


		Flux.just(P2P.builder().id("1").docNumber("70882402").cellNumber("956351426")
						.email("marco1021tam@gmail.com")
						.amountBootCoin(1500.00).build())
				.flatMap(p -> repository.save(p)).subscribe(p -> log.info("Insert: " + p.toString()));

		Flux.just(P2P.builder().id("2").docNumber("74748041").cellNumber("996768401")
						.email("angie.panaque@gmail.com")
						.amountBootCoin(5500.00).build())
				.flatMap(p -> repository.save(p)).subscribe(p -> log.info("Insert: " + p.toString()));

		Flux.just(P2P.builder().id("3").docNumber("09615979").cellNumber("983324931")
						.email("sofia.quiroz@gmail.com")
						.amountBootCoin(50.00).build())
				.flatMap(p -> repository.save(p)).subscribe(p -> log.info("Insert: " + p.toString()));


		Flux.just(PagoP2P.builder().idBuyer("1").idSeller("2").amountOperation(150.00).modePayment(1).status(0).numTransaction("191634698").build())
				.flatMap(p2 -> repositoryPago.save(p2)).subscribe(p2 -> log.info("Insert Bootcoin Pago: " + p2.toString()));

		Flux.just(PagoP2P.builder().idBuyer("2").idSeller("3").amountOperation(950.00).modePayment(2).status(1).numTransaction("21654966").build())
				.flatMap(p2 -> repositoryPago.save(p2)).subscribe(p2 -> log.info("Insert Bootcoin Pago: " + p2.toString()));

		log.debug("run");
	}


	@Bean
	public ReactiveRedisTemplate<String, P2P> reactiveJsonPostRedisTemplate(
			ReactiveRedisConnectionFactory connectionFactory) {

		RedisSerializationContext<String, P2P> serializationContext = RedisSerializationContext
				.<String, P2P>newSerializationContext(new StringRedisSerializer())
				.hashKey(new StringRedisSerializer())
				.hashValue(new Jackson2JsonRedisSerializer<>(P2P.class))
				.build();


		return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
	}

	@Bean
	public ReactiveRedisTemplate<String, PagoP2P> reactiveJsonPostRedisTemplatePago(
			ReactiveRedisConnectionFactory connectionFactory) {

		RedisSerializationContext<String, PagoP2P> serializationContext = RedisSerializationContext
				.<String, PagoP2P>newSerializationContext(new StringRedisSerializer())
				.hashKey(new StringRedisSerializer())
				.hashValue(new Jackson2JsonRedisSerializer<>(PagoP2P.class))
				.build();


		return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
	}


}
