FROM postgres

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=123

# Diretório contendo *.sql e *.sh que são executados na inicialização do Postgres
COPY dump.sql /docker-entrypoint-initdb.d/

EXPOSE 5432