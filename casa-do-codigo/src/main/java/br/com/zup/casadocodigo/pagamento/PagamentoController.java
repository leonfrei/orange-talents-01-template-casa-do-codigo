package br.com.zup.casadocodigo.pagamento;

import br.com.zup.casadocodigo.estado.EstadoRepository;
import br.com.zup.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new VerificarDocumentoCpfCnpjValidator(), new PaisTemEstadoValidator(paisRepository, estadoRepository));
    }

    @PostMapping
    public ResponseEntity pagar(@RequestBody @Valid NovoPagamentoFormulario novoPagamentoFormulario){
//        Pagamento pagamento = novoPagamentoFormulario.paraPagamento(paisRepository, estadoRepository);
        System.out.println(novoPagamentoFormulario);
//        pagamentoRepository.save(pagamento);
        return ResponseEntity.ok().build();
    }

}
