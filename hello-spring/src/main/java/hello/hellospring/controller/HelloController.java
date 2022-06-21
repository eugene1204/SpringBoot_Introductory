package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // method 실행
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!?!");
        return "hello";
        // templates/hello.html을 찾는다
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // body에 내용을 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 데이터를 그대로 넣어줌 소스코드봐도 문자만 나옴
    }

    @GetMapping("hello-api")
    @ResponseBody // 객체가 들어오면 json으로 반환한다.
    // HttpMessageConverter가 동작 -> 객체를 json으로 변경한다.
    // json으로 반환함

    /*
    * HTTP의 BODY에 문자 내용을 직접 반환
    * viewResolver 대신에 HttpMessageConverter 가 동작
    * 기본 문자처리: StringHttpMessageConverter
    * 기본 객체처리: MappingJackson2HttpMessageConverter
    * byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
    *
    * */
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() { // 외부에서 접근할수 있게
            return name;
        }
        public void setName(String name) { // 외부에서 접근할 수 있게
            this.name = name;
        } }
}
