/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.testkafka.workers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary Russell
 * @since 2.2.1
 */
@RestController
public class Controller {

	private final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private KafkaTemplate<String, Work> template;

	@PostMapping(path = "/send/foo/{what}")
	public void sendFoo(@PathVariable String what) throws InterruptedException {
		for (int i=1; i<=1000; i++) {
			this.template.send("temp", new Work(Double.valueOf(what)));
			this.logger.info("Message sent.");
//			Thread.sleep(10);
		}
	}

}
