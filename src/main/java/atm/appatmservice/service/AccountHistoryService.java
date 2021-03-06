package atm.appatmservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import atm.appatmservice.entity.AccountHistory;
import atm.appatmservice.entity.AccountType;
import atm.appatmservice.entity.enums.AccountTypeName;
import atm.appatmservice.entity.enums.RoleName;
import atm.appatmservice.payload.ApiResponse;
import atm.appatmservice.repository.AccountHistoryRepository;
import atm.appatmservice.repository.AccountTypeRepository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static atm.appatmservice.utils.CommonUtils.*;

@Service
public class AccountHistoryService {
    @Autowired
    AccountHistoryRepository accountHistoryRepository;

    @Autowired
    AccountTypeRepository accountTypeRepository;

    public ApiResponse getAllAccountHistory(Integer bankomatId) {
        if (checkAuthority(RoleName.ROLE_DIRECTOR)) {
            return new ApiResponse("You don't have the authority", false);
        }
        List<AccountHistory> accountHistories = accountHistoryRepository.findAllByBankomatId(bankomatId);
        return new ApiResponse("Account Histories", true, accountHistories);
    }

    public ApiResponse getDailyIncomesOrExpenses(Integer bankomatId, String dateText, AccountTypeName accountTypeName) {
        if (checkAuthority(RoleName.ROLE_DIRECTOR)) {
            return new ApiResponse("You don't have the authority", false);
        }
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(dateText);
        } catch (Exception dateException) {
            return new ApiResponse("Date incorrect", false, dateException);
        }

        Timestamp minDate, maxDate;

        Calendar calendar1 = getCalendarForDate(date);
        setTimeToBeginningOfDay(calendar1);
        minDate = new Timestamp(calendar1.getTime().getTime());

        Calendar calendar2 = getCalendarForDate(date);
        setTimeToEndOfDay(calendar2);
        maxDate = new Timestamp(calendar2.getTime().getTime());

        AccountType accountType = accountTypeRepository.findByName(accountTypeName);

        List<AccountHistory> accountHistories = accountHistoryRepository
                .findAllByBankomatIdAndAccountTypeIdAndDateBetween(bankomatId, accountType.getId(), minDate, maxDate);
        return new ApiResponse("Account Histories", true, accountHistories);
    }


}
