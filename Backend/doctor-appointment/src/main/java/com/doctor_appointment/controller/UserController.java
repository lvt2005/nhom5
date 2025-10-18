package com.doctor_appointment.controller;

import com.doctor_appointment.dto.request.UserRequestDTO;
import com.doctor_appointment.dto.response.ResponseData;
import com.doctor_appointment.dto.response.ResponseError;
import com.doctor_appointment.dto.response.UserDetailResponse;
import com.doctor_appointment.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j(topic = "USER-CONTROLLER")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseData<UserDetailResponse> getUser(@PathVariable @Min(1) Long userId){
        log.info("getUser: userId={}", userId);
        try {
            return new ResponseData<>(HttpStatus.OK.value(), "Get user", userService.getUser(userId));
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseData<?> getAllUsers(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                       @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize,
                                       @RequestParam(required = false) String sortBy){
        log.info("Get all users");

        try {
            return new ResponseData<>(HttpStatus.OK.value(), "Get all users",  userService.getAllUsersWithSortBy(pageNo, pageSize, sortBy));
        } catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
        }
    }


    @PostMapping("/add")
    public ResponseData<?> addUser(@Valid @RequestBody UserRequestDTO request){
        log.info("addUser: request={}", request);

        try {
            Long userId = userService.saveUser(request);
            return new ResponseData<>(HttpStatus.CREATED.value(), "Add user success", userId);
        } catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseData<Long> updateUser(@PathVariable @Min(1) Long userId,
                                         @Valid @RequestBody UserRequestDTO request){
        log.info("updateUser: userId={}", userId);

        try {
            return new ResponseData<>(HttpStatus.OK.value(), "Updated user", userService.updateUser(userId, request));
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
        }
    }

    @PatchMapping("/status/{userId}")
    public ResponseData<?> changeStatus(@PathVariable @Min(1) Long userId,
                                        @Valid @RequestBody UserRequestDTO request){

        log.info("changeStatus: userId={}", userId);

        try {
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Changed status", userService.changeStatus(userId, request));
        }catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
        }
    }

}
