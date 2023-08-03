package shop.mtcoding.conbasic.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.conbasic.dto.BoardReqDto;

@RestController
public class HttpBodyController {
    @PostMapping("/data/body/v1")
    public String bodyV1(@RequestParam("title") String title) {
        // @RequestParam은 없어도, title에 값을 입력하면 올바르게 출력이 된다.
        return "받은 값 : " + title;
    }

    @PostMapping("/data/body/v2")
    public String bodyV2(@RequestParam("title") String title, @RequestParam("content") String content) {
        return "받은 값 : " + title + ", " + content;
    }

    // localhost:8080/data/body/v3
    // post
    // x-www-form-urlencoded -> title=값&content=값
    // MIME 타입을 아래로 변경
    // application/json -> { "title":"값", "content":"값"}
    @PostMapping("/data/body/v3")
    public String bodyV3(@RequestBody BoardReqDto boardReqDto) {
        return "받은 값 : " + boardReqDto.getTitle() + ", " + boardReqDto.getContent();
    }
    // JSON 데이터를 받을 수 있다.
    // 통신은 현재 거의 JSON 형태로 이뤄진다.
    // Form 태그는 JSON 형태로 사용할 수 없으며, 자바스크립트를 통해 Form 태그 처럼 사용할 수 있다.
}
