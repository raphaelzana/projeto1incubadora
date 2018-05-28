package br.com.s2it.incubadora.projeto1incubadora;


import br.com.s2it.incubadora.projeto1incubadora.entity.Sugestao;
import br.com.s2it.incubadora.projeto1incubadora.service.ServiceSugestao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/sugestao")
public class SugestaoController {

    @Autowired
    private ServiceSugestao sugestaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Sugestao> getId(@PathVariable ("id") Long id){
        Sugestao sugestao = sugestaoService.find(id);
        return new ResponseEntity<Sugestao>(sugestao, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Sugestao>> getAll(){
        List<Sugestao> list = sugestaoService.findAll();
        return new ResponseEntity<List<Sugestao>>(list, HttpStatus.OK);
    }


    @PostMapping(value = "/")
    public ResponseEntity<Void> addSug(@RequestBody Sugestao sugestao, UriComponentsBuilder builder){
        sugestaoService.addSugestao(sugestao);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{id}").buildAndExpand(sugestao.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    /*@PutMapping("/{id}")
    public ResponseEntity<Sugestao> updatePath (@RequestBody Sugestao sugestao, @PathVariable("id") Long id){
        sugestaoService.update(sugestao, id);
        return new ResponseEntity<Sugestao>(sugestao, HttpStatus.NO_CONTENT);
    }*/

    @DeleteMapping("esponse/{id}")
    public ResponseEntity<Void> deleteSugestao (@PathVariable("id") Long id){
        sugestaoService.remover(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
