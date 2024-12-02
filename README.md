# Introdução

Projeto feito para a disciplina de Desenvolvimento Web do Instituto Federal de Educação Ciência e Tecnologia Catarinense - Campus Videira.

# Grupo

Felipe Biava Favarin e Francisco Augusto Neves Moreira Souza

# Título do Projeto

Best Ticket

## Tema escolhido

Um sistema de gerenciamento de eventos acadêmicos, que permita aos alunos visualizar os eventos em andamento no campus, inscrever-se neles, avaliá-los e sugerir novos eventos. O administrador deve poder cadastrar os eventos, incluindo todas as informações relevantes, e os alunos devem ter a opção de se inscrever.

# Ferramentas Usadas

IDE Visual Studio Code
Banco de Dados MySQL, linguagem SQL
Github
Linguagem Java
IDE IntelliJ IDEA
Uso do Spring framework
Uso do Lombok framework

## Explicação das classes

Para melhor desenvolvimento, organização e simplicidade, escolhemos o framework Spring. No qual oferece recursos necessários à grande parte das aplicações, como módulos para persistência de dados, integração, segurança, testes e desenvolvimento web, permitindo criar soluções menos acopladas, mais coesas e, consequentemente, mais fáceis de compreender e manter.
Pode ser encontranda em quase todas as classes das pastas **config**, **controller**, **repository**, **security** e **service**, além das classes *Application.java* e *Main.java* da pasta **vo**.

Uso do padrão Rest como vemos nas classes da pasta **controller**, com o @RestController e as rotas.

Foi usado a propriedade BCryptPasswordEncoder do spring, que usa hash para a criptografia de senhas, mantendo elas seguras e de simples implementação no código.

Além do uso da propriedade fastrxml.jackson do spring, para uma maneira simples de análise JSON em Java. Estando presente nas classes da pasta **vo**, a parte que vem do frontend do projeto.

Assim como, a propriedade javax deixando no padrão de arquitetura Rest para rotas.

O framework lombok ajudou na simplicidade de declaração de certos métodos utilizados, pode ser encontrado nas classes da pasta **entidade** e **vo**.

### Melhorias futuras

Possível implementação prática do projeto junto com o servidor e a aplicação. Isso pode vir a ser um tema de conclusão de curso ou servir como base após esta experiência de construção do projeto.

Possíveis implementações que trazem mais funções e edições aos eventos, podendo ser oferecido como projeto/prático funcional aos câmpus do Instituto Federal Catarinense, ou demais outros.
