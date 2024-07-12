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