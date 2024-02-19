package es.iesclaradelrey.da2d1a.psp.chucknorris.clienterest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClienteRest {

    @GetMapping("/chuck")
    public Joke getChuckNorris() {
        String url = "https://api.chucknorris.io/jokes/random";    // Cambia la URL según tu API REST
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Joke.class);
    }
}