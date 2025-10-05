package com.example.msvcclients.feign;

import com.example.msvcclients.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "msvc-users", url = "${msvc-users.url}")
public interface UserFeignClient {
    @GetMapping("/users")
    List<UserDTO> getUsers();
}