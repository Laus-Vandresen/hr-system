package br.com.payrollapi.services;

import br.com.payrollapi.domain.Payroll;
import br.com.payrollapi.feignClients.UserFeign;
import br.com.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign userFeign;

    public Payroll getPayment(Long workerId, Payroll payment) {
      log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("server.port") + " port");
      try {
          var user = userFeign.findById(workerId).getBody();
          if (Objects.nonNull(user)) {
              return new Payroll(user.getName(), payment.getDescription(), user.getHourlyPrice(), payment.getWorkedHours(), user.getHourlyPrice() * payment.getWorkedHours());
          }
      } catch (FeignException.NotFound feignException) {
          throw new ObjectNotFoundException("Object not found");
      } catch (Exception e) {
          throw new IllegalArgumentException("Illegal argument exception");
      }
      return null;
    }

}
