# Cantina — Back-end

Autor(a): Felipe Walker

Projeto desenvolvido na UC9 para evoluir o acesso aos dados da cantina escolar.

## Requisitos

- JDK 21.
- Apache Maven.
- VS Code com Extension Pack for Java.

## Organização

- `pom.xml`: configuração Maven e dependências.
- `src/main/java`: código Java.
- `dados`: pasta do futuro banco SQLite.
- `target`: arquivos gerados pela compilação.

## Compilar

Na raiz do projeto, onde está o pom.xml:

```bash
mvn compile
```

## Executar

Abrir a classe br.com.senac.main.Main e usar Run na extensão Java do VS Code.

## Banco de dados

URL preparada: jdbc:sqlite:dados/cantina.db.
O caminho é relativo à pasta de trabalho da execução.
Na aula 01, a aplicação apenas imprime a URL. A conexão será feita na aula 02.
