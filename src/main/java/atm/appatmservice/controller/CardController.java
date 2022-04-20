package atm.appatmservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import atm.appatmservice.payload.ApiResponse;
import atm.appatmservice.payload.CardDto;
import atm.appatmservice.service.CardService;

@RepositoryRestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/card/add")
    public HttpEntity<?> addCard(@RequestBody CardDto cardDto) {
        ApiResponse response = cardService.addCard(cardDto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }
}
