**Desafio**

Criar um sistema Web composto de um Front-end SPA (_Single Page Application_) Angular e um Back-end Java Spring Boot para envio de arquivos XML e posterior processamento deles.

**Requisitos**

- Criar uma interface Web para upload de um ou mais arquivos com extensão _.xml._ 
- Para o desenvolvimento da interface, deve ser utilizado o tema _Indigo_ do Angular Material.
- Durante o envio do(s) arquivo(s) mostrar um _loader_ para informar ao usuário que estão sendo processados, e ao final esse _loader_ deve desaparecer (utilizar componentes do Angular Material).
- Os arquivos contêm uma lista de agentes com código e data em formato ISO, e uma lista com quatro regiões (SE, S, NE, N) com sete valores numéricos de geração, compra e preço médio.
- Todos os arquivos seguem o mesmo formato, como nos exemplos em anexo:
  - _exemplo\_01.xml_
  - _exemplo\_02.xml_
  - _exemplo\_03.xml_
- Não é necessário validar os dados dos arquivos, considere que eles estarão sempre corretos e no formato especificado acima.
- Os arquivos devem ser lidos e enviados um a um, sequencialmente.
- Os arquivos podem conter quantidades grandes de dados, por exemplo, 1.000 agentes (agentes/agente[0..999])
- Os dados de preço médio (/agentes/agente[]/submercado[]/precoMedio) são confidenciais, portanto devem ser removidos ou substituídos por valores em branco _antes_ de serem enviados.
- Ao receber cada arquivo, o back-end deve apenas imprimir na saída padrão (_System.out_) os códigos de agentes (/agentes/agente[]/codigo) recebidos.

**Instruções**

1. Criar o sistema utilizando as seguintes tecnologias base:

- Front-end:
  - Angular 12+
  - Angular Material 12+
  - Typescript 4+
  - RxJS 6+
  - NodeJS 14+

- Back-end:
  - Spring Boot 2
  - Maven 3

1. Disponibilizá-lo em um repositório Git público (exemplo: GitHub, Bitbucket).
