
# Projeto prático API REST utilizando spring

Este projeto é uma implementação básica de uma API REST usando Spring, aplicando padrões de design como Facade, Repository e Strategy.

**Diagrama Entidade Relacionamento**
```mermaid
erDiagram
    User ||--o{ Reading : readings
    Reading ||--|| Book : book

    User {
        Long id PK
        String name
    }

    Book {
        Long id PK
        String title
        String author
        int totalPages
        String cloak
    }

    Reading {
        Long id PK
        int pagesRead
        Long book_id FK
    }
```


**Diagrama de classes**
```mermaid
classDiagram
class User {
  - String name
  - Long id
}

class Book {
  - Long id
  - String title
  - String author
  - int totalPages
  - String cloak
}

class Reading {
  - Long id
  - int pagesRead
  - Book book
}

User "1" -- "0..*" Reading : readings
Reading "1" -- "1" Book : book
```
