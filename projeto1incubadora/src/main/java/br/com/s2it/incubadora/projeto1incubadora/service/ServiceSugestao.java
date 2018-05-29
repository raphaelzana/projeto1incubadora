package br.com.s2it.incubadora.projeto1incubadora.service;
import br.com.s2it.incubadora.projeto1incubadora.entity.Sugestao;
import br.com.s2it.incubadora.projeto1incubadora.repository.sugestaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class ServiceSugestao {
    @Autowired
    private sugestaoRepository SugestaoRepository;
    public void addSugestao(Sugestao sugestao){
        LocalDateTime data = LocalDateTime.now();
        sugestao.setDataAtual(data);
        SugestaoRepository.save(sugestao);
    }
    public Sugestao find(Long id){
        return SugestaoRepository.findById(id).orElse(null);
    }
    public List<Sugestao> findAll(){
        return (List<Sugestao>) SugestaoRepository.findAll();
    }
    public void remover(Long id){SugestaoRepository.deleteById(id);}
}
