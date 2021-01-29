package br.com.zup.casadocodigo.pagamento;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerificarDocumentoCpfCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return NovoPagamentoFormulario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoPagamentoFormulario novoPagamentoFormulario = (NovoPagamentoFormulario) target;
        if (!novoPagamentoFormulario.documentoValido()){
            errors.rejectValue("documento", null, "Documento inserido não é valido");
        }
    }
}
