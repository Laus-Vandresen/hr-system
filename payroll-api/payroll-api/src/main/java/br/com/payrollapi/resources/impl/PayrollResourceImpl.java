package br.com.payrollapi.resources.impl;


import br.com.payrollapi.domain.Payroll;
import br.com.payrollapi.resources.PayrollResource;
import br.com.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PayrollResourceImpl implements PayrollResource {

    private final PayrollService payrollService;

    @RequestMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok(payrollService.getPayment(workerId, payment));
    }
}
