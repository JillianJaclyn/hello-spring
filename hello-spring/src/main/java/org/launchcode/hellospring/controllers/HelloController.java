package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//   @GetMapping("hello")
//   @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    @PostMapping
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {

        String greeting = "";

        if (language == null || language.equals("")) {
            greeting = "Hello";
        }
        else if (language.equals("french")) {
            greeting = "Bonjour";
        }
        else if (language.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (language.equals("spanish")) {
            greeting = "Hola";
        }
        else if (language.equals("swedish")) {
            greeting = "God dag";
        }

        return greeting + " " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name = 'language' id = 'languageSelect'>" +
                        "<option value = ''> English </option>" +
                        "<option value = 'spanish'> Spanish </option>" +
                        "<option value = 'french'> French </option>" +
                        "<option value = 'italian'> Italian </option>" +
                        "<option value = 'swedish'> Swedish </option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }


}
