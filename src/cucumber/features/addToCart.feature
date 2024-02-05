@cart
Feature: Wybór produktu na stronie T-Mobile

  Scenario: Wybieranie i dodawanie produktu do koszyka
    Given Użytkownik otwiera przeglądarkę i przechodzi na stronę T-Mobile
    When Użytkownik wybiera sekcję Urządzenia i wybiera te bez abonamentu
    And Użytkownik kliknie w pierwszy produkt z listy
    And Użytkownik dodaje pierwszy z listy produkt do koszyka
    Then Strona Twój koszyk zostaje wyświetlona z odpowiednimi kwotami
    When Użytkownik wraca na stronę główną T-Mobile
    Then Widoczna jest ikonka koszyka z liczbą produktów w koszyku
    And Użytkownik zamyka przeglądarke
