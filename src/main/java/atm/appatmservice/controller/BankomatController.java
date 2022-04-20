package atm.appatmservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import atm.appatmservice.payload.ApiResponse;
import atm.appatmservice.payload.BankomatDto;
import atm.appatmservice.payload.ClientMoneyDto;
import atm.appatmservice.payload.MoneyDto;
import atm.appatmservice.service.BankomatService;
import atm.appatmservice.service.BankomatServiceImpl;

@RepositoryRestController
@RequiredArgsConstructor
public class BankomatController {

    private final BankomatService bankomatService;

    @PostMapping("/bankomat/add")
    public HttpEntity<?> add(@RequestBody BankomatDto bankomatDto) {
        ApiResponse response = bankomatService.add(bankomatDto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 403).body(response);
    }

    @PostMapping("/bankomat/fill")
    public HttpEntity<?> fill(@RequestBody MoneyDto moneyDto) {
        ApiResponse response = bankomatService.fill(moneyDto);
        return ResponseEntity.status(response.isSuccess() ? 202 : 403).body(response);
    }

    @PostMapping("/bankomat/withdraw")
    public HttpEntity<?> withdraw(@RequestBody ClientMoneyDto clientMoneyDto) {
        ApiResponse response = bankomatService.withdraw(clientMoneyDto);
        return ResponseEntity.status(response.isSuccess() ? 200 : 403).body(response);
    }

    @PostMapping("/bankomat/replenishCard")
    public HttpEntity<?> replenishCard(@RequestBody MoneyDto moneyDto) {
        ApiResponse response = bankomatService.replenishCard(moneyDto);
        return ResponseEntity.status(response.isSuccess() ? 200 : 403).body(response);
    }

}
