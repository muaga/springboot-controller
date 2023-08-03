package shop.mtcoding.conbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpPathController {

    @GetMapping("/data/path/v1/{id}")
    public String pathV1(@PathVariable("id") int id) {
        return "받은 값 : " + id;
    }
    // 주소에 데이터를 실어서, {}해당 데이터를 달라(조회를 위해서)

    // 쿼리스트링, PathVariable 데이터 조회
    // Path - PK
    // 쿼리스트링 - PK 외
}
