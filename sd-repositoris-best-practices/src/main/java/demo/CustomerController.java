/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

/**
 * @author Thomas Darimont
 */
@RequestMapping("/customers")
@RestController
class CustomerController {

	private final CustomerRepository repository;

	@Autowired
	public CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}

	/**
	 * Find with dynamically generated predicates.
	 * 
	 * <pre>
	 * curl -v http://localhost:8080/customers/search\?firstname=Ralf | jq .
	 * </pre>
	 * 
	 * <pre>
	 * curl -v http://localhost:8080/customers/search\?lastname=Daub | jq .
	 * </pre>
	 * 
	 * @param predicate
	 * @return
	 */
	@RequestMapping("/search")
	public Iterable<Customer> findAllBy(Predicate predicate) {
		return repository.findAll(predicate);
	}
}
