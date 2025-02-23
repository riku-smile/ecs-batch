package com.batch

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource

@SpringBootTest
@ActiveProfiles("test")
class BatchApplicationTests {

	companion object {
		@JvmStatic
		@DynamicPropertySource
		fun properties(registry: DynamicPropertyRegistry) {
			registry.add("spring.datasource.url") { 
				"jdbc:mysql://localhost:3306/batch_test_db?useSSL=false&allowPublicKeyRetrieval=true" 
			}
			registry.add("spring.datasource.username") { "test_user" }
			registry.add("spring.datasource.password") { "test_pass" }
		}
	}

	@Test
	fun contextLoads() {
	}

}
