package br.com.payrollapi.resources;

import br.com.payrollapi.domain.Payroll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface PayrollResource {

    @RequestMapping("/{workerId}")
    ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment);
}
