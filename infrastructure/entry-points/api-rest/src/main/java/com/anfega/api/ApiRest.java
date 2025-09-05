package com.anfega.api;

import com.anfega.model.user.User;
import com.anfega.model.user.gateways.UserInputPort;
import com.anfega.api.dto.UserDTO;
import com.anfega.api.dto.CreateUserDTO;
import com.anfega.api.mapper.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final UserInputPort userInputPort;
    private final UserDTOMapper userDTOMapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userDTOMapper.toResponse(userInputPort.getUserById(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody CreateUserDTO createUserDTO) {
        User user = userDTOMapper.toModel(createUserDTO);
        return ResponseEntity.ok(userDTOMapper.toResponse(userInputPort.saveUser(user)));
    }
}
