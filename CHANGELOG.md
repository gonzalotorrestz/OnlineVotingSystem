# Online Voting System Changelog

All notable changes to this project will be documented in this file.

## [0.1.0] - 2024-03-16

### Changed

- Refactor "user creation" for "user registration". 
- Modified User entity class:
  - Removed "username" field.
  - Add "password" field with encoding functionality and strength validation.
  - Add "enabled" field. It sets to false by default.
  - Add "registrationDate" (auto completes on successful user creation) and "lastLoginDate" fields.

## [0.0.4] - 2024-03-16

### Changed

- User creation validations added on UserController (on previous commit). Removed unnecessary variables and console logs.

## [0.0.3] - 2024-03-16

### Added

- ResponseDTO to handle responses.

## [0.0.2] - 2024-03-16

### Changed

- Country entity parameters and getters/setters names (removed "country" from the names because it felt redundant).

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

