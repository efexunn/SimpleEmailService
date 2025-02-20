# SimpleMailService

SimpleMailService is a project that enables email sending using Spring Boot. This project has two different Spring profiles:

- **Dev** Profile: Used for local development and testing. It utilizes the MailDev service running in Docker for email testing.
- **Prod** Profile: Used for real email sending via Gmail's SMTP server with real email addresses. Please be careful!

## Installation and Usage

### 1. Running in Development Mode (Dev Profile)

For local development, MailDev is used to capture and inspect sent emails. Follow these steps to get started:

#### a) **Start MailDev Service with Docker Compose**

Run the following command in the root directory of the project to start the MailDev service:

```sh
docker-compose up -d
```

After starting the service, you can access the MailDev UI at [**http://localhost:1080**](http://localhost:1080).

#### b) **Start the Spring Boot Application with the "dev" Profile**

Run the following command to start the Spring Boot application in development mode:

Change the active profile to "dev" in application.properties file.

Emails sent in this mode can be viewed in the MailDev interface.

---

### 2. Running in Production Mode (Prod Profile)

In production mode, emails are sent using Gmail’s SMTP server. Follow these steps to set up your production environment:

#### a) **Obtain a Gmail Application Password**

Since Gmail requires additional security measures, you need to create an "Application Password" to send emails from your application:

1. [Log into your Google Account](https://myaccount.google.com/).
2. Navigate to the "Security" section.
3. Find and open the "App Passwords" section.
4. Generate a new application password and save it for later use.
5. After that use your personal email address and generated password in the application-prod.properties file.

#### b) **Use Gmail SMTP Settings and Start the Application in Prod Profile**

Run the application in `prod` profile using the following command:

Change the active profile to "prod" in application.properties file.

In production mode, emails will be sent to actual recipients via Gmail.

---

## Docker Compose Configuration

The `docker-compose.yml` file in the root directory should contain the following:

```yaml
version: '3.8'
services:
  maildev:
    image: maildev/maildev
    container_name: maildev
    ports:
      - "1080:1080"  # Web Interface
      - "1025:1025"  # SMTP Server
```

This service is used for testing emails during development.

---

## Summary

- **In development mode (`dev` profile)**, MailDev running in Docker is used for email testing.
- **In production mode (`prod` profile)**, real emails are sent via Gmail's SMTP service.
- To use Gmail SMTP in production, you need to obtain an "Application Password."

Feel free to contribute or report any issues by opening a PR or Issue! 🚀
