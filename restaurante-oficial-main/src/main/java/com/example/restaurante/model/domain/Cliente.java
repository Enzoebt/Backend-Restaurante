package com.example.restaurante.model.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//import org.springframework.boot.context.properties.ConfigurationProperties;

//import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

  //  @CPF
  //  @NotBlank
    @Column(nullable = false)
    private String cpf;
    private String telefone;

    //@Email
    private String email;

    @ManyToMany
    @JoinTable(
      name = "cliente_mesa",
      joinColumns = @JoinColumn(name = "cliente_id"),
      inverseJoinColumns = @JoinColumn(name = "mesa_id")
      )
    private Set<Mesa> mesas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;
    
    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("[^0-9]", "");
    }
}
