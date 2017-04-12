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

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
   * <p>
   * <pre>
   * curl -v http://localhost:8080/customers/search\?firstname=Ralf | jq .
   * </pre>
   * <p>
   * <pre>
   * curl -v http://localhost:8080/customers/search\?lastname=Daub | jq .
   * </pre>
   *
   * @param predicate
   * @return
   */
  @GetMapping("/search")
  Iterable<Customer> findAllBy(Predicate predicate) {
    return repository.findAll(predicate);
  }

  /**
   * Restrict queries to a subset of fields via Query by Example and a custom query Object.
   *
   * <pre>
   * http://localhost:8080/customers/search2?firstname=Ralf&lastname=St
   * </pre>
   *
   * @param customerQuery
   * @return
   */
  @GetMapping("/search2")
  Iterable<Customer> findByExample(@Valid CustomerQuery customerQuery) {
    return repository.findAll(customerQuery.toExample());
  }
}
