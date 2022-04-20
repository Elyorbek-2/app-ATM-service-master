package atm.appatmservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import atm.appatmservice.entity.ReplenishAtmHistory;
import atm.appatmservice.entity.Role;
import atm.appatmservice.entity.enums.RoleName;
import atm.appatmservice.payload.ApiResponse;
import atm.appatmservice.repository.ReplenishAtmHistoryRepository;
import atm.appatmservice.utils.CommonUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static atm.appatmservice.utils.CommonUtils.checkAuthority;

@Service
public class ReplenishAtmHistoryService {
    @Autowired
    ReplenishAtmHistoryRepository replenishAtmHistoryRepository;

    public ApiResponse getReplenishingBankomatHistories(Integer bId) {
        if (checkAuthority(RoleName.ROLE_DIRECTOR)) {
            return new ApiResponse("You don't have the authority", false);
        }

        List<ReplenishAtmHistory> replenishAtmHistoryList = replenishAtmHistoryRepository.findAllByBankomatId(bId);
        return new ApiResponse("Replenishing ATM histories", true, replenishAtmHistoryList);
    }


}
