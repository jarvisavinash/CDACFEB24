# ReactJS App and .NET Core WebAPI Setup Guide

This guide provides steps to set up a ReactJS frontend application and a .NET Core WebAPI backend.

## Prerequisites

Ensure you have the following installed:
- Visual Studio Code
- Visual Studio Code 2022
- Eclipse
- MySQL & MySQL WorkBench
- GitHub Desktop
- Node.js and npm (for ReactJS)
- Postman


## ReactJS App Setup

1. **Clone the Repository**
    ```bash
    git clone https://github.com/jarvisavinash/CDACFEB24.git
    cd your-react-app
    ```

2. **Install Dependencies**
    ```bash
    npm install
    ```

3. **Run the React App**
    ```bash
    npm start
    ```
    Your React app should be running on `http://localhost:3000`.

## .NET Core WebAPI Setup

1. **Clone the Repository**
    ```bash
    git clone https://github.com/jarvisavinash/CDACSEPT23.git
    cd your-dotnet-webapi
    ```

2. **Run the WebAPI**
    Open the project in your preferred IDE (Visual Studio, VS Code, etc.)

3. **Set Up CORS in Program.cs**
    - Open `Program.cs`.
    - Add CORS configuration in the `ConfigureServices` and `Configure` methods. Example provided in [this guide](#configure-cors-in-programcs).

4. **Migrations using Entity Framework Core**
    To perform database migrations using Entity Framework Core:
    - Open a terminal or command prompt in the root directory of your WebAPI project.
    - Run the following commands:
        ```bash
        dotnet ef migrations add InitialCreate -o Data/Migrations
        dotnet ef database update
        ```
    This will create the initial migration and apply it to your database.


## NuGet Packages (for .NET Core)

This project utilizes the following NuGet packages:

- **Microsoft.EntityFrameworkCore (v6.0.3)**
  - Entity Framework Core is an ORM for .NET. It's used for database interactions.
  - [NuGet Package](https://www.nuget.org/packages/Microsoft.EntityFrameworkCore/6.0.3)

- **Microsoft.EntityFrameworkCore.Tools (v6.0.3)**
  - EF Core Tools contain additional commands for Entity Framework Core.
  - [NuGet Package](https://www.nuget.org/packages/Microsoft.EntityFrameworkCore.Tools/6.0.3)

- **Pomelo.EntityFrameworkCore.MySql (v6.0.1)**
  - Pomelo MySQL provider for Entity Framework Core. Enables MySQL database integration.
  - [NuGet Package](https://www.nuget.org/packages/Pomelo.EntityFrameworkCore.MySql/6.0.1)


## Configure CORS in Program.cs

```csharp
// Example CORS Configuration in Program.cs

using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

var builder = WebApplication.CreateBuilder(args);

// Other configurations...

// Configure services
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowSpecificOrigin",
        builder =>
        {
            builder.WithOrigins("http://localhost:3000")
                   .AllowAnyHeader()
                   .AllowAnyMethod();
        });
});

var app = builder.Build();

// Other configurations...

// Configure CORS middleware
app.UseCors("AllowSpecificOrigin");

// Other configurations...

app.Run();
```


# Spring Boot Application Setup Guide

This guide provides step-by-step instructions on how to create and set up a Spring Boot application using Spring Initializr and configure it to run a basic REST API using MySQL as the database.

## Creating a Spring Boot Application using Spring Initializr:

1. Go to [Spring Initializr](https://start.spring.io/).
2. Fill in the required project details:
   - **Project:** Maven or Gradle (Select Maven for this example)
   - **Language:** Java 
   - **Spring Boot:** Choose the desired version (e.g., 3.2.1)
   - **Project Metadata:** Group, Artifact, Name, and Description
   - **Dependencies:** Add dependencies for `Spring Web`, `Spring Data JPA`, and `MySQL Driver`.
   - **Packaging: Jar or War (Select Jar for this example)
   - **Java: 17 (or your preferred version)
3. Click on "Generate" to download the project zip file.
4. **Unzip the downloaded zip file:**
   Unzip the downloaded project zip file in your preferred location on your machine.
5. **Importing the Project into Eclipse:**
   - Open Eclipse IDE.
   - Click on `File`.
   - Select `Import`.
   - Expand `Maven`.
   - Choose `Existing Maven Projects`, then click `Next`.
   - Browse to the directory where you unzipped the project.
   - Click `Next`.

6. **Building and Running the Application:**
   - Once the project is imported, right-click on the project in the Eclipse Project Explorer.
   - Go to `Run As` and select `Spring Boot App` or `Java Application`.
   - The Spring Boot application will start, and you'll see logs in the console indicating that the application has started.
   - Open a web browser and go to `http://localhost:8080` to access the default application endpoint (if available).
  

# CORS Configuration in Spring Boot

This guide demonstrates how to configure CORS (Cross-Origin Resource Sharing) in a Spring Boot application to allow cross-origin requests.

## Configuring CORS in Spring Boot:

1. **Create a Configuration Class for CORS:**
   Create a configuration class to define CORS settings.

   ```java
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.cors.CorsConfiguration;
   import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
   import org.springframework.web.filter.CorsFilter;

   @Configuration
   public class CorsConfig {
       @Bean
       public CorsFilter corsFilter() {
           UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
           CorsConfiguration config = new CorsConfiguration();

           // Configure allowed origins, headers, methods, etc.
           config.addAllowedOrigin("*"); // Set the allowed origin, "*" allows all origins
           config.addAllowedHeader("*"); // Set the allowed headers, "*" allows all headers
           config.addAllowedMethod("*"); // Set the allowed HTTP methods, "*" allows all methods

           source.registerCorsConfiguration("/**", config);
           return new CorsFilter(source);
       }
   }



## Contributing

Contributions are welcome! Fork the repository, make your changes, and submit a pull request.
