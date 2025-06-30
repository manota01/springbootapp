# springbootapp

This Spring Boot application fetches rental property listings for postcode 2147 in NSW from `realestate.com.au` using Jsoup. It exposes a single endpoint:

- `GET /properties` – returns a JSON list of properties with title, address and price.

Due to network restrictions in some environments, the actual request to `realestate.com.au` may fail. The code is provided as an example and may require adjustments to match the site's HTML structure or to use an official API if available.

## Running locally

```bash
./mvnw spring-boot:run
```

Then browse to `http://localhost:8080/properties`.
