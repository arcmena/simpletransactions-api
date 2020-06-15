# Simple Transactions API

![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/arcmena/simpletransactions-api?style=flat-square)
![GitHub top language](https://img.shields.io/github/languages/top/arcmena/simpletransactions-api?style=flat-square)

Simple Transactions is a Java Spring API that you can use to test _financial transactions_.

## Getting started

To run the API locally you will need to have Java 8 and PostgreSQL 10 installed in your environment.

### Installing

To install the repository and start working on your implementation open your terminal, go to your project folder and type:

```ssh
git clone https://github.com/arcmena/simpletransactions-api.git
```

It will clone the repository inside your project folder.

### Configuring the environment

In order to run the app you will need to configure your Database access into `src/main/resources/application.properties`.

```bash
spring.datasource.url=jdbc:postgresql://HOST:5432/DATABASENAME
spring.datasource.username= USERNAME
spring.datasource.password= PASSWORD
```

The remaining of the configurations can stay the same.

### Starting

The recomended way to start is using an IDE to run the `SimpleTransactionsApplication.java` in the path: `src\main\java\com\simplemoney\transactions\SimpleTransactions\`

#### If you don't have any IDE to compile:

To be able to run the app without any IDE to compile it, you will need to first build it with maven.

Run in your terminal:

```ssh
maven install
```

Then run the jar generated from the build:

```ssh
java -jar target/SimpleTransactions-0.0.1-SNAPSHOT.jar
```

> The server should be running in http://localhost:8080. Check for usage below.

## Usage

> **Note:** You can test the endpoints in your localhost or at the hosted app in Heroku https://simpletransactions.herokuapp.com

The endpoints are:

- _GET_ `transaction\all` - to get all the transactions in the database.

- _GET_ `transaction\[id]` - to get a specific transaction where "[id]" is the id of the transaction, shown on the all route above.

- _POST_ `transaction\` - to create a new transaction, use the post method and send a GET request with a JSON body containing the data as shown in the example:

```bash
    {
        "date": "2020-06-15",
        "time": "12:10:00",
        "value": 199.90,
        "cardApplication": "CREDITO",   #The value here is a enum, it only accepts the values: DEBITO, CREDITO and VOUCHER
        "status": "SUCCESS"             #The value here is a enum, it only accepts the values: SUCCESS, PENDING, CANCELED and FAILED
    }
```

- _PUT_ `transaction\[id]` - to update an already existing transaction, using the id provided in the URL and sending a PUT request with the new data on the body as shown above.

> **Note:** Not sending a POST or PUT request with the body as intended above, will cause Exception Throws, the messages will show on the response, if it's not a Exception that has been treated, it will be printed the error in the terminal.

## Author

- **Marcelo Mena** - [arcmena](https://github.com/arcmena)
