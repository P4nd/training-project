# Entities

## **User**
Id, Name, Document, DoB, Gender, OccupationId

## Occupation
Id, Name

## Role
Id, Name

## UserRoles
Id, Name

# Repositories

## UserRepository

- Get all (*Occupation*)

- Add new (*Occupation*)

- Delete one (*Occupation*)

- Update one (*Occupation*)
  


## RoleRepository

- Get All
- Add new
- Delete one
- Update one
  

## UserRolesRepository

- Get all (*User* and *Roles*)

- Add new (*User* and *Roles*)

- Delete one
  

# Endpoint { /api/user }

## POST - Create

{ Json Body } 200 Ok | 406 Not Acceptable | 500 Internal Server Error

## GET - Retrieve
200 Ok | 204 No Content | 500 Internal Server Error

## PUT - Update

{ Json Body } 200 Ok | 304 Not Modified | 406 Not Acceptable | 500 Internal Server Error

## DELETE - Remove
{ Query Parameter - Id } 200 Ok| 404 Not Found | 403 Forbidden | 500 Internal Server Error