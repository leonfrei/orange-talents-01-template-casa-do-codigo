package br.com.zup.casadocodigo.pagamento;

import br.com.zup.casadocodigo.compartilhado.ExistValue;
import br.com.zup.casadocodigo.compartilhado.UniqueValue;
import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.estado.EstadoRepository;
import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.pais.PaisRepository;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoPagamentoFormulario {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistValue(fieldName = "id", domainClass = Pais.class, message = "Não existe nenhum pais com esse id")
    private Long idPais;
    @ExistValue(fieldName = "id", domainClass = Estado.class, message = "Não existe nenhum estado com esse id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Optional<Long> getIdEstado() {
        return Optional.ofNullable(idEstado);
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Pagamento paraPagamento(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        return new Pagamento( email, nome, sobrenome, documento, endereco, complemento, cidade, paisRepository.getOne(idPais), estadoRepository.getOne(idEstado), telefone, cep);
    }

    public boolean documentoValido() {
        Assert.hasLength(documento, "você não deveria validar o documento se ele nao estiver preechido");
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
    }
}
