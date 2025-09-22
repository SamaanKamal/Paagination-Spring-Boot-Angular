package com.example.Pagination.resource;

import com.example.Pagination.domain.HttpResponse;
import com.example.Pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok().body(HttpResponse.builder().timeStamp(LocalDate.now().toString()).status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).
                message("Users Retrieved").data(Map.of("page", userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10)))).build());
    }
}
