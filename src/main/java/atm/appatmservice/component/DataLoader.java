package atm.appatmservice.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import atm.appatmservice.entity.*;
import atm.appatmservice.entity.enums.RoleName;
import atm.appatmservice.repository.*;
import atm.appatmservice.entity.Role;
import atm.appatmservice.entity.User;
import atm.appatmservice.repository.RoleRepository;
import atm.appatmservice.repository.UserRepository;

import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BankRepository bankRepository;

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            User user = new User(
                    "John",
                    "Doe",
                    "hikmatillayevjavohir5@mail.ru",
                    passwordEncoder.encode("123")
            );
            Role director = roleRepository.findByName(RoleName.ROLE_DIRECTOR);
            Bank ipak_yuli_banki = bankRepository.findByName("IPAK_YULI_BANKI");
            user.setBank(ipak_yuli_banki);
            user.setRoles(Collections.singleton(director));
            user.setEnabled(true);
            userRepository.save(user);
        }
    }
}
