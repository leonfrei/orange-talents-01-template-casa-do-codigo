package br.com.zup.casadocodigo.pagamento;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.estado.EstadoRepository;
import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class PaisTemEstadoValidator implements Validator {

    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public PaisTemEstadoValidator(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoPagamentoFormulario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoPagamentoFormulario novoPagamentoFormulario = (NovoPagamentoFormulario) target;
        Pais pais = paisRepository.findById(novoPagamentoFormulario.getIdPais()).get();
        boolean empty = novoPagamentoFormulario.getIdEstado().isEmpty();
        if (empty){
            return;
        }
        Estado estado = estadoRepository.findById(novoPagamentoFormulario.getIdEstado().get()).get();
        if (!estado.pertenceAoPais(pais)) {
            errors.rejectValue("idEstado", null, "Estado nao pertence a este pais");
        }
    }
}
