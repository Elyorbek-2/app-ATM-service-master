package atm.appatmservice.service;

import atm.appatmservice.payload.ApiResponse;
import atm.appatmservice.payload.BankomatDto;
import atm.appatmservice.payload.ClientMoneyDto;
import atm.appatmservice.payload.MoneyDto;

public interface BankomatService {

    ApiResponse add(BankomatDto bankomatDto);

    ApiResponse fill(MoneyDto moneyDto);

    ApiResponse withdraw(ClientMoneyDto clientMoneyDto);

    ApiResponse replenishCard(MoneyDto moneyDto);
}
