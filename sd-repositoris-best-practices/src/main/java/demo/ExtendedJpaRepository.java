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

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;

/**
 * @author Thomas Darimont
 *
 * @param <T>
 * @param <ID>
 */
public class ExtendedJpaRepository<T, ID extends Serializable> //
		extends QueryDslJpaRepository<T, ID> // if you don't use QueryDSL you should just extend SimpleJpaRepositoriy
		implements ExtendedRepository<T, ID> {

	public ExtendedJpaRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	@Override
	public List<T> findAllWithMyGenericMethod() {
		
		System.out.println("findAllWithMyGenericMethod");
		
		return findAll();
	}
}
