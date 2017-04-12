package demo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.validation.constraints.Size;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

interface CustomerQuery {

  String getFirstname();

  @Size(min = 2)
  String getLastname();

  default Example toExample() {

    ExampleMatcher matching = ExampleMatcher.matching().withMatcher("lastname", startsWith());

    return Example.of(new Customer(getFirstname(), getLastname()), matching);
  }
}
