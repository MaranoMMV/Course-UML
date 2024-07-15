# Projeto prático UML curso Udemy



Projeto realizado na udemy, feito a partir da UML basica do Professor que foi criada no SpringBoot 1.x, e consegui atualizar com sucesso para a versão 3.x do SpringBoot.




Neste projeto, foi utilizado o Lombok que é uma biblioteca do Java muito famosa, se você não conhece ela, é uma biblioteca que consegue gerar os codigos como Getters, Setters, Construtores dentre outros apenas com a Annotation em cima da classe. vou demonstrar no codigo abaixo.
Também o codigo consegue ficar muito mais limpo, e você consegue visualizar o codigo e editar o codigo muito mais facilmente, e sem muita perda de tempo. Otimo para projetos que está começando agora e que não tem um UML preparado antecipadamente e precisar ficar editando a classe.
OBS: No parenteses, é para ignorar que é apenas um informativo o que cada annotation é utilizado.




Instalação do lombok eclipse SpringTools:
https://ia-tec-development.medium.com/lombok-como-instalar-na-spring-tool-suite-4-ide-48defb1d0eb9




No arquivo pom.xml. coloque a Dependencia: 

```
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>	
		<optional>true</optional>
	</dependency>
```


```

@Data
(gera os getters, setters e toString )

@NoArgsConstructor 
(gera um construtor vazio)

@AllArgsConstructor 
 (Gera um construtor com todas as variaveis da classe, deixando elas de forma automatica. )

```

## Requisições: 

Aqui está todas as requisições que estão mapeadas na API, no campo {id} deve estar colocado a numeração que você quer buscar, se caso ela não existir ele vai retornar um 404 - Not Found. se encontrar vai retornar uma estruturação igual que está abaixo.

### GET Cliente: 
```
http://localhost:8080/api/clientes/{id}

Retorna: {
    "id": 1,
    "nome": "Maria Silva",
    "email": "maria@gmail.com",
    "cpfOuCnpj": "3678912377",
    "tipo": "PESSOAFISICA",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua flores",
            "numero": "300",
            "complemento": "apto 303",
            "bairro": "Jardim",
            "cep": "7123651235"
        },
        {
            "id": 2,
            "logradouro": "Av Matos",
            "numero": "105",
            "complemento": "Sala 800",
            "bairro": "Centro",
            "cep": "12931983"
        }
    ],
    "telefones": [
        "123687123",
        "263176312"
    ]
}


```

### GET Pedidos:

```
http://localhost:8080/api/pedidos/{id}

Retorna:

{
    "id": 1,
    "instante": "30/09/2017 01:32",
    "pagamento": {
        "id": 1,
        "estado": "PENDENTE",
        "numeroDeParcelas": 6
    },
    "cliente": {
        "id": 11,
        "nome": "Maria Silva",
        "email": "maria@gmail.com",
        "cpfOuCnpj": "3678912377",
        "tipo": "PESSOAFISICA",
        "enderecos": [
            {
                "id": 21,
                "logradouro": "Rua flores",
                "numero": "300",
                "complemento": "apto 303",
                "bairro": "Jardim",
                "cep": "7123651235"
            },
            {
                "id": 22,
                "logradouro": "Av Matos",
                "numero": "105",
                "complemento": "Sala 800",
                "bairro": "Centro",
                "cep": "12931983"
            }
        ],
        "telefones": [
            "123687123",
            "263176312"
        ]
    },
    "enderecoDeEntrega": {
        "id": 21,
        "logradouro": "Rua flores",
        "numero": "300",
        "complemento": "apto 303",
        "bairro": "Jardim",
        "cep": "7123651235"
    },
    "itens": []
}

```

### GET Categorias:

```
http://localhost:8080/api/categorias/{id}

Retorna:

{
    "id": 19,
    "nome": "Informatica",
    "produtos": [
        {
            "id": 1,
            "nome": "Computador",
            "preco": 2000.0
        },
        {
            "id": 2,
            "nome": "Impressora",
            "preco": 800.0
        },
        {
            "id": 3,
            "nome": "Mouse",
            "preco": 80.0
        }
    ]
}
```

Faltou colocar mais alguma coisa nesse readme? só me comunicar que estarei a disposição, e podem ocorrer atualizações futuras.

