# Organização

Todos os componentes devem estar no ROOT, sendo controlado pelos observables padrões.
Evitando assim duplicidade de componentes ao redor da aplicação.


**Ex1:** O grid fará o carregamento inicia, ao clicar em visualizar. Enviamos o objeto ao Observable<T>
com ação de abrir a Sidebar para exibição dos dados.


**Ex2:** O grid fará o carregamento inicia, ao clicar em editar, enviamos ao Observable<T> no Root,
e abrimos o formulário com os dados preenchidos.

Caso o usuário atualize com sucesso esses dados, reenviamos ao Observable<T> para que o mesmo reflita em outro componente.


# Observables



## Notifications

Type : NotificationType
Title (string)
Message (string)

## Actions

Type : ActionType
RelatedId : number|null
Wrapper : <T>|null (where T : Single<Null, User, Occupation, Role or UserRoles>)

# Pages

- User
- Role
- UserRole
  

# Templates

- GridTemplate (*tabela, listas...*)
- FormTemplate (*formulário apenas*)
- SidebarTemplate (*aba lateral direita*)
- ModalTemplate (*caixa de diálogo*)
- Notification (*mensagens flutuates a direta*)
  

# Components

- GridRowItem
- DefinitionListItem
- FormRowItem
- GridCellButtons
- ModalActionButtons
- NotificationBox
  

# Services & DI's

- UserServices
- RoleServices
- UserRoleServices
  
- Observable<Notifications>
- Observable<Action>
  

# Models & Enum

- User (Id, Name, Document, DoB, Gender, OccupationId)
- Occupation (Id, Name)
- Role (Id, Name)
- UserRoles (Id, UserId, RoleId)
  
- ActionType (Submit, Dismiss, Remove, Notify, View, Confirm)
- NotificationType (Info, Warning, Success, Danger)