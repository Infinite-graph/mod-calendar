package org.folio.calendar.controller;

import java.math.BigDecimal;
import org.folio.calendar.domain.dto.ArithmeticRequest;
import org.folio.calendar.domain.dto.Arithmetics;
import org.folio.calendar.domain.dto.Greeting;
import org.folio.calendar.exception.InvalidDivisionException;
import org.folio.calendar.rest.resource.HelloApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloWorldController implements HelloApi {

  @Override
  public ResponseEntity<Greeting> getHelloWorld(String tenantId, String salutation) {
    Greeting sampleResponse = new Greeting();
    sampleResponse.setHello(salutation + " " + tenantId + "!");
    return new ResponseEntity<>(sampleResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Arithmetics> postHello(String xOkapiTenant, ArithmeticRequest request) {
    Arithmetics answers = new Arithmetics();
    answers.setSum(request.getA() + request.getB());
    answers.setProduct(request.getA() * request.getB());
    try {
      answers.setQuotient(new BigDecimal(request.getA()).divide(new BigDecimal(request.getB())));
    } catch (ArithmeticException e) {
      throw new InvalidDivisionException(e);
    }

    return new ResponseEntity<>(answers, HttpStatus.OK);
  }
}
