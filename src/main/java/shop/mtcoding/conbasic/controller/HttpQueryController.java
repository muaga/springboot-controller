package shop.mtcoding.conbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpQueryController {

    @GetMapping("/data/query/v1")
    public String queryV1(@RequestParam("keyword") String keyword) {
        // "keyword"로 받은 쿼리스트링을 파싱할 수 있다.
        // 쿼리스트링의 key 이름 : "keyword"
        // 쿼리스트링의 value 값 : 언급을 하지 않으니, 오류가 뜬다. value값을 입력해줘야 올바른 출력이 진행된다.
        // 직접 URL에 [?keyword=값] 이렇게
        return "받은 값 : " + keyword;
    }

    @GetMapping("/data/query/v2")
    public String queryV2(@RequestParam(value = "keyword", required = false) String keyword) {
        // required = false : null 허용
        return "받은 값 : " + keyword;
    }

    @GetMapping("/data/query/v3")
    public String queryV3(@RequestParam(value = "keyword", required = false, defaultValue = "cos") String keyword) {
        // defaultValue = "cos" : 안 받았을 때, 디폴트값
        return "받은 값 : " + keyword;
    }

    //////////////////////////////////////////// 위의 두 가지 조건을 사용하고 싶을 때,
    //////////////////////////////////////////// @RequestParam을 쓴다.

    @GetMapping("/data/query/v4")
    public String queryV4(String keyword) {
        // @RequestParam을 생략하면 얻어지는 기능
        // 1. 쿼리스트링의 key 이름 : String keyword
        // 2. 쿼리스트링의 value 값 : null 허용
        return "받은 값 : " + keyword;
    }

    /*
     * ★ 예외 ★
     * 로그인 같은 경우, {id} = PK를 @PathVariable을 해서, 이와 관련된 데이터를 가지고 와야 된다.
     * 그냥 매개변수만 작성했을 경우(Integer id) @RequestParam으로 인식을 해서
     * 엔드포인트가 /user/update 이렇게만 될 것이다.
     * 이 경우 숨겨진 엔드포인트는 [?id = X ]라서, id에 관한 value가 없다. -> 오류가 터진다.
     * Get요청은 URL에 뜨는 value를 가지고 와서 내부 메소드를 실행을 하는데, 실행을 하지 못한다.
     * 직접 /user/update?id=1 이라고 치면 해당 브라우저는 열린다.
     * 매번 직접 URL을 작성하면서 value 값을 넣어주지 않아도, 자동으로 열리도록 하기 위해 @PathVariable을 사용한다.
     */

    @GetMapping("/data/query/v5")
    public String queryV5(String keyword, String type) {
        // &로 구분지어서 출력할 수 있다.
        return "받은 값 : " + keyword + ", " + type;
    }
}
