# Online Voting System Changelog

All notable changes to this project will be documented in this file.

## [0.0.1] - 2024-03-14

### Added

- License, Changelog and Readme files.
- Swagger Configuration.
- Entities:
  - User (Model, Controller, DTO, Repository, Service)
  - Country (Model)
- Utils
  - EntityDTOConverter Interface
- Endpoints:
  - `POST /users`: Create a new user.
  - `GET /users`: Retrieve all users.
- Base URL for the API has been updated.

### Database

- Liquibase configurations 
- "Country" changeset to preload entity with initial values.

