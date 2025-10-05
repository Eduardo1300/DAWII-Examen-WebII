package com.example.msvcclients.controller;

import com.example.msvcclients.feign.UserFeignClient;
import com.example.msvcclients.model.Client;
import com.example.msvcclients.model.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

@RestController
public class ClientController {
    private final UserFeignClient userFeignClient;
    private final Random random = new Random();

    public ClientController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return userFeignClient.getUsers().stream().map(user -> {
            String usuario = (user.getNombres() + "." + user.getApellidos()).toLowerCase();
            String contrasenia = Long.toHexString(random.nextLong());
            return new Client(user.getId(), user.getDni(), user.getNombres(), user.getApellidos(), usuario, contrasenia);
        }).collect(Collectors.toList());
    }
}
