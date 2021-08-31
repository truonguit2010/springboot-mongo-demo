package com.realbizgames.demo.mongo.controller;

import com.realbizgames.demo.mongo.dto.UserDTO;
import com.realbizgames.demo.mongo.exception.BaseServiceException;
import com.realbizgames.demo.mongo.service.IUserService;
import com.realbizgames.demo.mongo.template.ResponseFactory;
import com.realbizgames.demo.mongo.template.ResponseTemplate;
import com.realbizgames.demo.mongo.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseTemplate<Object> handleException(Exception e) {
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();

        if (e instanceof BaseServiceException) {
            code = ((BaseServiceException) e).getErrorCode().getCode();
        }
        log.error(e.getMessage(), e);
        return ResponseFactory.failed(code, e.getMessage());
    }

    @PostMapping()
    public ResponseTemplate<Object> create(@RequestBody UserDTO dto) {
        UserDTO createdOne = userService.create(dto);
        return ResponseFactory.success(createdOne);
    }

    @PutMapping()
    public ResponseTemplate<Object> update(@RequestBody UserDTO dto) {
        userService.update(dto);
        return ResponseFactory.success();
    }

    @PatchMapping()
    public ResponseTemplate<Object> patch(@RequestBody UserDTO dto) {
        userService.patch(dto);
        return ResponseFactory.success();
    }

    @DeleteMapping("/{id}")
    public ResponseTemplate<Object> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseFactory.success();
    }

    @GetMapping()
    public ResponseTemplate<Object> get(//
                                        @RequestParam(required = false) String id, //
                                        @RequestParam(required = false) String action, //
                                        @RequestParam(required = false) Integer page, //
                                        @RequestParam(required = false) Integer offset, //
                                        @RequestParam(required = false) Integer limit //

    ) {
        if (StringUtils.isNotNullOrEmpty(id)) {
            UserDTO dto = userService.get(id);
            return ResponseFactory.success(dto);
        } else {
            String msg = MessageFormat.format("Action({0}) is not supported", action);
            throw new RuntimeException(msg);
        }
    }
}
