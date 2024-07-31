# language: en
@gestionarPropietarios
Feature: Gestionar Propietarios

  @listarPropietarios
  Scenario: Listar todos propietarios
    Given el cliente navega a la página de propietarios
    When el cliente realiza una acción para listar propietarios
    Then la página debe mostrar una lista de propietarios válida

  ##Veterinarians
  @ListarVeterinarians
  Scenario: Listar todos los Veterinarians
    Given el cliente navega a la pagina de Veterinarians
    When el cliente realiza una acción para listar Veterinarians
    Then la página debe mostrar una lista de Veterinarians válidos

  @VerJsonDeListaVeterinarians
  Scenario: El cliente ve la lista de veterinarios en formato JSON
    Given el cliente navega a la pagina de Veterinarians
    When el cliente realiza una acción para listar Veterinarians
    Then la página debe mostrar un enlace para abrir el JSON
    When el cliente hace clic en el enlace JSON
    Then el cliente debe ver el JSON con la lista de Veterinarians
