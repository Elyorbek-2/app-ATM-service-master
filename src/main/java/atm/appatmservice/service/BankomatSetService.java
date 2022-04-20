package atm.appatmservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import atm.appatmservice.entity.BankomatSet;
import atm.appatmservice.entity.enums.RoleName;
import atm.appatmservice.payload.ApiResponse;
import atm.appatmservice.repository.BankomatSetRepository;

import java.util.List;

import static atm.appatmservice.utils.CommonUtils.checkAuthority;

@Service
public class BankomatSetService {

    @Autowired
    BankomatSetRepository bankomatSetRepository;

    public ApiResponse getAllBanknoteInfoByBankomatId(Integer bId) {
        if (checkAuthority(RoleName.ROLE_DIRECTOR)) {
            return new ApiResponse("You don't have the authority", false);
        }
        List<BankomatSet> bankomatSetList = bankomatSetRepository.findAllByBankomatId(bId);
        return new ApiResponse("Banknotes info",true,bankomatSetList);

    }

}
